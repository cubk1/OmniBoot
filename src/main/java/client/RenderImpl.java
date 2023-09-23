package client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import org.union4dev.omni.elements.IRender;
import org.union4dev.omni.elements.wrapper.IResourceLocation;

public class RenderImpl implements IRender {
    @Override
    public void glBlendFunc(int sFactorRGB, int dFactorRGB, int sfactorAlpha, int dfactorAlpha) {
        OpenGlHelper.glBlendFunc(sFactorRGB, dFactorRGB, sfactorAlpha, dfactorAlpha);
    }

    @Override
    public void bindTexture(IResourceLocation resource) {
        Minecraft.getMinecraft().getTextureManager().bindTexture((ResourceLocation) resource);
    }

    @Override
    public void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
        Gui.drawModalRectWithCustomSizedTexture(x, y, u, v, width, height, textureWidth, textureHeight);
    }
}
