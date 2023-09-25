package org.union4dev.omni.components.event.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.union4dev.omni.elements.event.Event;

@Getter@AllArgsConstructor
public class ClassScanEvent implements Event {
    private Class<?> clazz;
}
