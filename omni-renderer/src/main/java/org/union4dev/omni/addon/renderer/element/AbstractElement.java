package org.union4dev.omni.addon.renderer.element;

import lombok.ToString;

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
    public final void draw(int mouseX, int mouseY) {
        if (!this.visible) return;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractElement)) return false;
        final AbstractElement that = (AbstractElement) o;
        return this.visible == that.visible && this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.visible, this.x, this.y);
    }

}
