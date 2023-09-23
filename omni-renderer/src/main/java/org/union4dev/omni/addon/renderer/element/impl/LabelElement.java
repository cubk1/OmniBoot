package org.union4dev.omni.addon.renderer.element.impl;

import lombok.Getter;
import lombok.Setter;
import org.union4dev.omni.addon.renderer.element.AbstractElementWithBody;
import org.union4dev.omni.addon.renderer.element.RenderFlag;
import org.union4dev.omni.elements.wrapper.IFontRenderer;

import java.awt.*;

public class LabelElement extends AbstractElementWithBody implements RenderFlag {

    @Getter
    private final IFontRenderer fontRenderer;

    @Getter
    private String text;

    @Getter @Setter
    private Color fill;

    @Getter @Setter
    private Color outline;

    private final int flags;

    public LabelElement(IFontRenderer fontRenderer, String text , int x, int y, Color fill, int flags) {
        super(x, y, fontRenderer.getWidth(text), fontRenderer.getHeight());
        this.fontRenderer = fontRenderer;
        this.text = text;
        this.fill = fill;
        this.flags = flags;
    }

    public LabelElement(IFontRenderer fontRenderer, String text , int x, int y, Color fill,Color outline, int flags) {
        super(x, y, fontRenderer.getWidth(text), fontRenderer.getHeight());
        this.fontRenderer = fontRenderer;
        this.text = text;
        this.fill = fill;
        this.outline = outline;
        this.flags = flags;
    }

    public LabelElement(IFontRenderer fontRenderer, String text , int x, int y, Color fill) {
        super(x, y, fontRenderer.getWidth(text), fontRenderer.getHeight());
        this.fontRenderer = fontRenderer;
        this.text = text;
        this.fill = fill;
        this.flags = 0;
    }

    public LabelElement(IFontRenderer fontRenderer, String text , int x, int y) {
        super(x, y, fontRenderer.getWidth(text), fontRenderer.getHeight());
        this.fontRenderer = fontRenderer;
        this.text = text;
        this.fill = Color.WHITE;
        this.flags = 0;
    }


    public void setText(String text) {
        this.text = text;
        setWidth(fontRenderer.getWidth(text));
        setHeight(fontRenderer.getHeight());
    }

    @Override
    public void onDraw(int mouseX, int mouseY) {
        if((flags & STRING_OUTLINE) != 0) {
            fontRenderer.drawOutlinedString(text, x, y, fill.getRGB(),outline.getRGB());
        }else {
            if ((flags & STRING_SHADOW) != 0) {
                fontRenderer.drawStringWithShadow(text, x, y, fill.getRGB());
            } else {
                fontRenderer.drawString(text, x, y, fill.getRGB());
            }
        }
    }

    @Override
    public void setPosition(int x, int y) {
        super.setPosition(x, y);
    }
}
