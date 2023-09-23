package org.union4dev.omni.addon.renderer.element;

import org.union4dev.omni.elements.wrapper.IScaledResolution;

public interface Element {

    void draw(IScaledResolution scaledResolution);

    void onDraw(int mouseX, int mouseY);

    boolean isVisible();

    void setVisible(boolean visible);

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    default void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

}
