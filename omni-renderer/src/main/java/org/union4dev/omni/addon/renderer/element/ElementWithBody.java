package org.union4dev.omni.addon.renderer.element;

public interface ElementWithBody {

    boolean isHovered(int mouseX, int mouseY);

    int getWidth();

    void setWidth(int width);

    int getHeight();

    void setHeight(int height);

}
