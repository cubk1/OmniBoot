package client.module.render;

import client.module.Module;
import org.lwjgl.input.Mouse;
import org.union4dev.omni.addon.renderer.element.RenderFlag;
import org.union4dev.omni.addon.renderer.element.impl.LabelElement;
import org.union4dev.omni.addon.renderer.event.Render2DEvent;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.annotations.features.RegisterTo;
import org.union4dev.omni.annotations.features.Startup;
import org.union4dev.omni.components.module.Category;
import org.union4dev.omni.components.module.ModuleManager;
import org.union4dev.omni.elements.module.ModuleCategory;

import java.awt.*;

@RegisterTo(ModuleManager.class)
@Startup
public class HUD extends Module {

    private final LabelElement label = new LabelElement(mc.fontRendererObj,"Fuck",2,2, Color.WHITE, RenderFlag.STRING_SHADOW);

    public HUD() {
        super("HUD", Category.RENDER);
    }

    @EventTarget
    public void onRender(Render2DEvent event){
        label.draw(event.getScaledResolution());
    }
}
