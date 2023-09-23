package org.union4dev.omni.components.event;

import org.union4dev.omni.Omni;
import org.union4dev.omni.annotations.event.ModuleDepend;
import org.union4dev.omni.annotations.event.NullCheck;
import org.union4dev.omni.elements.event.Event;
import org.union4dev.omni.annotations.event.EventPriority;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.components.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class EventManager extends Component {
    private final Map<Method, Class<?>> registeredMethodMap;
    private final Map<Method, Object> methodObjectMap;
    private final Map<Class<? extends Event>, List<Method>> priorityMethodMap;

    public EventManager() {
        registeredMethodMap = new ConcurrentHashMap<>();
        methodObjectMap = new ConcurrentHashMap<>();
        priorityMethodMap = new ConcurrentHashMap<>();
    }

    public void register(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == EventTarget.class && method.getParameterTypes().length == 1) {
                    registeredMethodMap.put(method, method.getParameterTypes()[0]);
                    methodObjectMap.put(method, obj);

                    Class<? extends Event> eventClass = method.getParameterTypes()[0].asSubclass(Event.class);
                    priorityMethodMap.computeIfAbsent(eventClass, k -> new ArrayList<>()).add(method);
                }
            }
        }
    }


    public void unregister(Object obj) {
        Class<?> clazz = obj.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (registeredMethodMap.containsKey(method)) {
                registeredMethodMap.remove(method);
                methodObjectMap.remove(method);
                Class<? extends Event> eventClass = method.getParameterTypes()[0].asSubclass(Event.class);
                List<Method> priorityMethods = priorityMethodMap.get(eventClass);
                if (priorityMethods != null) {
                    priorityMethods.remove(method);
                }
            }
        }
    }

    public Event call(Event event) {
        Class<? extends Event> eventClass = event.getClass();

        if(eventClass.isAnnotationPresent(NullCheck.class)){
            if(Omni.getInstance().getClient().nullCheck())
                return event;
        }

        List<Method> methods = priorityMethodMap.get(eventClass);
        if (methods != null) {
            methods.sort(Comparator.comparingInt(method -> {
                EventPriority priority = method.getAnnotation(EventPriority.class);
                return (priority != null) ? priority.value() : 10;
            }));

            for (Method method : methods) {
                if(method.isAnnotationPresent(ModuleDepend.class)){
                    ModuleDepend moduleDepend = method.getAnnotation(ModuleDepend.class);
                    if(!Omni.getInstance().getModuleManager().getByClass(moduleDepend.value()).isEnabled())
                        continue;
                }

                Object obj = methodObjectMap.get(method);
                method.setAccessible(true);
                try {
                    method.invoke(obj, event);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return event;
    }

    @Override
    public void initiate() {

    }
}