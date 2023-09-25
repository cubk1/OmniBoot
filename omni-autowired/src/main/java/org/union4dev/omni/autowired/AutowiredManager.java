package org.union4dev.omni.autowired;

import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.components.ComponentManager;
import org.union4dev.omni.components.event.EventManager;
import org.union4dev.omni.components.event.internal.ClassScanEvent;
import org.union4dev.omni.components.management.ManagerComponent;
import org.union4dev.omni.elements.plugin.OmniPlugin;
import org.union4dev.omni.elements.wrapper.IClient;
import org.union4dev.omni.struct.Pair;

import java.lang.reflect.Field;

public class AutowiredManager extends ManagerComponent<Pair<Class<?>,Object>> implements OmniPlugin {

    @Override
    public void initiate() {

    }

    @EventTarget
    public void onScan(ClassScanEvent event){
        try {
            addValue(new Pair<>(event.getClazz(),event.getClazz().newInstance()));
            handleAutowired();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void handleAutowired(){
        for (Pair<Class<?>,Object> entry : getValues()) {
            for (Field declaredField : entry.getFirst().getDeclaredFields()) {
                declaredField.setAccessible(true);
            }
        }
    }

    @Override
    public String getName() {
        return "Autowired";
    }

    @Override
    public void load(IClient client, ComponentManager manager) {
        manager.getByClass(EventManager.class).register(this);
    }
}
