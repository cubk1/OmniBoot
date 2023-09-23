package org.union4dev.omni.addon.renderer.util;

import lombok.experimental.UtilityClass;
import org.lwjgl.opengl.GL11;

@UtilityClass
public class GLUtil {
    public void glColor(int hex) {
        float alpha = (hex >> 24 & 0xFF) / 255.0F;
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        GL11.glColor4f(red, green, blue, alpha);
    }
}
