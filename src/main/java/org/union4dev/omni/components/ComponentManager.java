package org.union4dev.omni.components;

import org.union4dev.omni.components.event.EventManager;
import org.union4dev.omni.components.features.BindManager;
import org.union4dev.omni.components.features.Category;
import org.union4dev.omni.components.features.CommandManager;
import org.union4dev.omni.components.features.ModuleManager;
import org.union4dev.omni.components.management.ManagerComponent;

public class ComponentManager extends ManagerComponent<Component> {
    @Override
    public void initiate() {

    }

    @Override
    public void registerCallback(Component instance) {
        instance.initiate();
    }
}
