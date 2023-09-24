package org.union4dev.omni.components.event.internal;

import org.union4dev.omni.elements.event.Event;

public class KeyPressEvent implements Event {
    private int key;

    public KeyPressEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }

}
