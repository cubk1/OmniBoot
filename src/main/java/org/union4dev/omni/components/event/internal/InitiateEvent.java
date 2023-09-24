package org.union4dev.omni.components.event.internal;

import lombok.Getter;
import org.union4dev.omni.elements.event.Event;

import java.util.ArrayList;
import java.util.List;

public class InitiateEvent implements Event {

    @Getter
    private final List<Class<?>> classes = new ArrayList<>();

    public void addToScanList(Class<?> cl) {
        classes.add(cl);
    }

}
