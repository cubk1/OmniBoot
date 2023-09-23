package org.union4dev.omni.elements.configuration;

import org.union4dev.omni.elements.event.EventState;

public interface Toggleable {
    void setEnable(boolean enable);

    boolean isEnabled();

    void toggle();

    void onEnable(EventState state);

    void onDisable(EventState state);
}
