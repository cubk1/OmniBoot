package client.module.render;

import client.module.Module;
import client.module.movement.Sprint;
import org.union4dev.omni.Omni;
import org.union4dev.omni.addon.renderer.element.RenderFlag;
import org.union4dev.omni.addon.renderer.element.impl.LabelElement;
import org.union4dev.omni.addon.renderer.element.impl.RectangleElement;
import org.union4dev.omni.addon.renderer.event.Render2DEvent;
import org.union4dev.omni.annotations.event.EventTarget;
import org.union4dev.omni.annotations.event.ModuleDepend;
import org.union4dev.omni.annotations.features.RegisterTo;
import org.union4dev.omni.annotations.features.Startup;
import org.union4dev.omni.components.features.Category;
import org.union4dev.omni.components.features.ModuleManager;
import org.union4dev.omni.elements.module.AbstractModule;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

@RegisterTo(ModuleManager.class)
@Startup
public class HUD extends Module {

    private final LabelElement label = new LabelElement(mc.fontRendererObj, "Sprinting", 2, 2, Color.WHITE, RenderFlag.STRING_SHADOW);

    public HUD() {
        super("HUD", Category.RENDER);
    }

    @EventTarget
    @ModuleDepend(Sprint.class)
    public void onRender(Render2DEvent event) {
        label.draw(event.getScaledResolution());
    }

    @EventTarget
    public void onRenderArray(Render2DEvent event) {
        int width = event.getScaledResolution().getScaledWidth();
        int y = 1;
        ArrayList<AbstractModule> enabledModules = new ArrayList<>();
        for (AbstractModule m : Omni.getInstance().getModuleManager().getValues()) {
            if (m.isEnabled()) {
                enabledModules.add(m);
            }
        }
        enabledModules.sort((o1, o2) -> mc.fontRendererObj.getStringWidth(o2.getName()) - mc.fontRendererObj.getStringWidth(o1.getName()));
        for (AbstractModule m : enabledModules) {
            int moduleWidth = mc.fontRendererObj.getStringWidth(m.getName());
            mc.fontRendererObj.drawStringWithShadow(m.getName(), width - moduleWidth - 1, y, -1);
            y += mc.fontRendererObj.FONT_HEIGHT;
        }
    }
}
