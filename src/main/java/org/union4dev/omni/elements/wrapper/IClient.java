package org.union4dev.omni.elements.wrapper;

public interface IClient {
    void initiate();
    boolean nullCheck();
    void printMessage(String message);

    IRender getRenderer();
}
