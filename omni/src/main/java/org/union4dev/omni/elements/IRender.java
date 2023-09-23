package org.union4dev.omni.elements;

import org.union4dev.omni.elements.wrapper.IResourceLocation;

public interface IRender {
    void glBlendFunc(int sFactorRGB, int dFactorRGB, int sfactorAlpha, int dfactorAlpha);

    void bindTexture(IResourceLocation resource);

    void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight);
}
