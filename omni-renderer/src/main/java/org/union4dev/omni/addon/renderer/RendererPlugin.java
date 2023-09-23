package org.union4dev.omni.addon.renderer;

import org.union4dev.omni.components.ComponentManager;
import org.union4dev.omni.elements.plugin.OmniPlugin;
import org.union4dev.omni.elements.wrapper.IClient;

public class RendererPlugin implements OmniPlugin {
    @Override
    public void load(IClient client, ComponentManager manager) {
    }

    @Override
    public String getName() {
        return "OmniRenderer";
    }
}
