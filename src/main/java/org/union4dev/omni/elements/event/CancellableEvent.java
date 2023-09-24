package org.union4dev.omni.elements.event;


import lombok.Getter;
import lombok.Setter;

public abstract class CancellableEvent implements Event, Cancellable {
	@Getter @Setter
	public boolean cancelled;
}
