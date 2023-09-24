package org.union4dev.omni.elements.wrapper;

public interface IFontRenderer {
    float drawString(String text, double x, double y, int color);
    float drawStringWithShadow(String text, double x, double y, int color);
    float drawCenteredString(String text, double x, double y, int color) ;
    float drawCenteredStringWithShadow(String text, double x, double y, int color);
    void drawOutlinedString(String str, float x, float y, int internalCol, int externalCol);
    int getWidth(String text);
    int getHeight();
}
