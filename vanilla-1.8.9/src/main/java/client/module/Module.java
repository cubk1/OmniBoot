package client.module;

import net.minecraft.client.Minecraft;
import org.union4dev.omni.elements.module.AbstractModule;
import org.union4dev.omni.elements.module.ModuleCategory;

public class Module extends AbstractModule {
    protected final Minecraft mc = Minecraft.getMinecraft();

    public Module(String name, ModuleCategory category) {
        super(name, category);
    }

    public Module(String name, ModuleCategory category, int key) {
        super(name, category, key);
    }
}
