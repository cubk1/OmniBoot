package org.union4dev.omni.elements.plugin;

import org.union4dev.omni.components.ComponentManager;
import org.union4dev.omni.elements.configuration.Label;
import org.union4dev.omni.elements.wrapper.IClient;

public interface OmniPlugin extends Label {
    void load(IClient client, ComponentManager manager);

}
