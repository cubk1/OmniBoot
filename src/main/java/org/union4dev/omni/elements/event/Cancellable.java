package org.union4dev.omni.elements.event;


public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean state);

}
