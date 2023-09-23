package org.union4dev.omni.addon.renderer.element.impl;

import lombok.Getter;
import lombok.Setter;
import org.lwjgl.opengl.GL11;
import org.union4dev.omni.addon.renderer.element.AbstractElementWithBody;
import org.union4dev.omni.addon.renderer.element.RenderFlag;

import java.awt.*;

public class RectangleElement extends AbstractElementWithBody implements RenderFlag {

    @Getter
    @Setter
    private Color fill;

    private final int flags;

    public RectangleElement(int x, int y, int width, int height, Color fill, int flags) {
        super(x, y, width, height);
        this.fill = fill;
        this.flags = flags;
    }

    @Override
    public void onDraw(int mouseX, int mouseY) {
        if ((flags & TRANSPARENT) == 0) {
            int col1 = getFill().getRGB();
            float f2 = (float) (col1 >> 24 & 255) / 255.0f;
            float f22 = (float) (col1 >> 16 & 255) / 255.0f;
            float f3 = (float) (col1 >> 8 & 255) / 255.0f;
            float f4 = (float) (col1 & 255) / 255.0f;
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GL11.glColor4f(f22, f3, f4, f2);
            GL11.glBegin(7);
            GL11.glVertex2d(x + width, y);
            GL11.glVertex2d(x, y);
            GL11.glVertex2d(x, y + height);
            GL11.glVertex2d(x + width, y + height);
            GL11.glEnd();
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glDisable(2848);
            GL11.glPopMatrix();
        }
    }
}
