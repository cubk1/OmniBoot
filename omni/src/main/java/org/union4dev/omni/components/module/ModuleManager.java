package org.union4dev.omni.components.module;

import org.union4dev.omni.Omni;
import org.union4dev.omni.annotations.event.EventPriority;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.annotations.features.Startup;
import org.union4dev.omni.components.event.internal.KeyPressEvent;
import org.union4dev.omni.components.management.LabelManagerComponent;
import org.union4dev.omni.elements.module.AbstractModule;
import org.union4dev.omni.elements.value.AbstractValue;

import java.lang.reflect.Field;
import java.util.List;

public class ModuleManager extends LabelManagerComponent<AbstractModule> {
    @Override
    public void initiate() {
        Omni.getInstance().getEventManager().register(this);
    }

    @EventTarget
    @EventPriority(1)
    public void onKeyPress(KeyPressEvent event) {
        for (AbstractModule m : getValues()) {
            if (m.getKey() == event.getKey()) m.setEnable(!m.isEnabled());
        }
    }

    @Override
    public void registerCallback(AbstractModule instance) {
        Class<?> moduleClass = instance.getClass();
        if(moduleClass.isAnnotationPresent(Startup.class))
            instance.setEnable(true);
        if(Boolean.parseBoolean(Omni.getInstance().getProperties().getProperty("reflection-value"))){
            for (final Field field : moduleClass.getDeclaredFields()) {
                try {
                    field.setAccessible(true);
                    final Object obj = field.get(instance);
                    if (obj instanceof AbstractValue) instance.getValues().add((AbstractValue<?>) obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void setValues(List<AbstractModule> values){
        this.values = values;
    }
}
