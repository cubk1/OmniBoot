package org.union4dev.omni.components.event.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.union4dev.omni.elements.event.Event;
import org.union4dev.omni.elements.value.internal.ModeValue;

@AllArgsConstructor @Getter
public class InvalidModeEvent implements Event {
    private ModeValue mode;
    private String name;
}
