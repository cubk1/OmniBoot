package org.union4dev.omni.addon.renderer.element;

import lombok.ToString;
import org.lwjgl.input.Mouse;
import org.union4dev.omni.elements.wrapper.IScaledResolution;

import java.util.Objects;

@ToString
public abstract class AbstractElement implements Element {

    protected boolean visible = true;
    protected int x, y;

    public AbstractElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public final void draw(IScaledResolution scaledResolution) {
        if (!this.visible) return;
        int mouseX = Mouse.getX() / scaledResolution.getScaleFactor(), mouseY = scaledResolution.getScaledHeight() - (Mouse.getY() / 2);
        onDraw(mouseX, mouseY);
    }


    @Override
    public boolean isVisible() {
        return this.visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

}
