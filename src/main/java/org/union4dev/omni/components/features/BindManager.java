package org.union4dev.omni.components.features;

import lombok.extern.log4j.Log4j2;
import org.union4dev.omni.Omni;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.components.event.internal.KeyPressEvent;
import org.union4dev.omni.components.management.ManagerComponent;
import org.union4dev.omni.struct.Pair;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Log4j2
public class BindManager extends ManagerComponent<Pair<Integer,Method>> {
    @Override
    public void initiate() {
        Omni.getInstance().getEventManager().register(this);
    }

    @EventTarget
    public void onKeyPress(KeyPressEvent event) {
        for (Pair<Integer,Method> p : getValues()) {
            if (p.getFirst() == event.getKey()) {
                try {
                    p.getSecond().invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    log.catching(e);
                }
            }
        }
    }
}
