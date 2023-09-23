package org.union4dev.omni.addon.renderer.element.impl;

import lombok.Getter;
import org.lwjgl.opengl.GL11;
import org.union4dev.omni.Omni;
import org.union4dev.omni.addon.renderer.element.RenderFlag;
import org.union4dev.omni.elements.wrapper.IResourceLocation;

import java.awt.*;

public class ImageElement extends RectangleElement implements RenderFlag {

    @Getter
    private final IResourceLocation location;

    public ImageElement(IResourceLocation resourceLocation, int x, int y, int width, int height) {
        this(resourceLocation, x, y, width, height, Color.WHITE);
    }

    public ImageElement(IResourceLocation resourceLocation, int x, int y, int width, int height, Color fill) {
        super(x, y, width, height, fill, 0);
        this.location = resourceLocation;
    }

    @Override
    public void onDraw(int mouseX, int mouseY) {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        Omni.getInstance().getRender().glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f((float) getFill().getRed() / 255.0f, (float) getFill().getBlue() / 255.0f, (float) getFill().getRed() / 255.0f, 1.0f);
        Omni.getInstance().getRender().bindTexture(location);
        Omni.getInstance().getRender().drawModalRectWithCustomSizedTexture(x, y, 0.0f, 0.0f, width, height, (float) width, (float) height);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
}
