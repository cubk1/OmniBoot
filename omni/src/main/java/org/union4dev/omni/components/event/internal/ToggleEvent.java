package org.union4dev.omni.components.event.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.union4dev.omni.elements.event.CancellableEvent;
import org.union4dev.omni.elements.module.AbstractModule;

@Getter @AllArgsConstructor
public class ToggleEvent extends CancellableEvent {
    private AbstractModule module;
    private boolean state;
}
