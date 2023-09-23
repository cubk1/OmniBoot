package client.module.render;

import client.module.Module;
import org.union4dev.omni.addon.renderer.element.RenderFlag;
import org.union4dev.omni.addon.renderer.element.impl.LabelElement;
import org.union4dev.omni.addon.renderer.element.impl.RectangleElement;
import org.union4dev.omni.addon.renderer.event.Render2DEvent;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.annotations.features.RegisterTo;
import org.union4dev.omni.annotations.features.Startup;
import org.union4dev.omni.components.features.Category;
import org.union4dev.omni.components.features.ModuleManager;

import java.awt.*;

@RegisterTo(ModuleManager.class)
@Startup
public class HUD extends Module {

    private final LabelElement label = new LabelElement(mc.fontRendererObj, "Fuck", 2, 2, Color.WHITE, RenderFlag.STRING_SHADOW);
    private final RectangleElement rect = new RectangleElement(0, 0, 100, 100, new Color(0, 0, 0, 100), RenderFlag.TRANSPARENT);

    public HUD() {
        super("HUD", Category.RENDER);
    }

    @EventTarget
    public void onRender(Render2DEvent event) {
        label.draw(event.getScaledResolution());
        rect.draw(event.getScaledResolution());
    }
}
