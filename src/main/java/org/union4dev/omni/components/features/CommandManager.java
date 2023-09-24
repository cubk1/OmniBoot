
package org.union4dev.omni.components.features;

import lombok.extern.log4j.Log4j2;
import org.union4dev.omni.Omni;
import org.union4dev.omni.annotations.features.Command;
import org.union4dev.omni.components.management.ManagerComponent;
import org.union4dev.omni.util.Multithreading;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Log4j2
public class CommandManager extends ManagerComponent<Object> {

    @Override
    public void initiate() {

    }

    public boolean processCommand(String rawMessage) {
        String prefix = Omni.getInstance().getProperties().getProperty("command-prefix");

        if (!rawMessage.startsWith(prefix)) {
            return false;
        }

        String[] args = rawMessage.trim().substring(1).split(" ");

        Class<?> command = null;
         Object object = null;

        for(Object o : getValues()){
            Class<?> clazz = o.getClass();
            Command cmd = clazz.getAnnotation(Command.class);
            for(String s : cmd.value()){
                if (s.equalsIgnoreCase(args[0])) {
                    command = clazz;
                    object = o;
                    break;
                }
            }
        }

        if(command != null){
            for(Method method : command.getDeclaredMethods()){
                if(method.isAnnotationPresent(Command.HandleCommand.class)){
                    try {
                        Command.HandleCommand handleCommand = method.getAnnotation(Command.HandleCommand.class);
                        if(handleCommand.await()){
                            method.invoke(object, (Object) Arrays.copyOfRange(args, 1, args.length));
                        }else {
                            Object finalObject = object;
                            Multithreading.runAsync(() -> {
                                try {
                                    method.invoke(finalObject, (Object) Arrays.copyOfRange(args, 1, args.length));
                                } catch (IllegalAccessException | InvocationTargetException e) {
                                    log.catching(e);
                                }
                            });
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        log.catching(e);
                    }
                }
            }
        }else {
            Omni.getInstance().getClient().printMessage("Invalid usage, try use help.");
        }


        return true;
    }



}
