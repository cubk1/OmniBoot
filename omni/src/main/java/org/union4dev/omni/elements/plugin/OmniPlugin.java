package org.union4dev.omni.elements.plugin;

import org.union4dev.omni.components.ComponentManager;
import org.union4dev.omni.elements.IClient;
import org.union4dev.omni.elements.configuration.Label;

public interface OmniPlugin extends Label {
    void load(IClient client, ComponentManager manager);

}
