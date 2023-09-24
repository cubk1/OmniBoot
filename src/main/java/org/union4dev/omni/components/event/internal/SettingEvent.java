package org.union4dev.omni.components.event.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.union4dev.omni.elements.event.CancellableEvent;
import org.union4dev.omni.elements.value.AbstractValue;

@AllArgsConstructor @Getter
public class SettingEvent<A> extends CancellableEvent {
    private AbstractValue<A> value;
    @Setter
    private A newValue;
}
