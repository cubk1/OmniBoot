package org.union4dev.omni.components;

import org.union4dev.omni.components.bind.BindManager;
import org.union4dev.omni.components.command.CommandManager;
import org.union4dev.omni.components.event.EventManager;
import org.union4dev.omni.components.management.ManagerComponent;
import org.union4dev.omni.components.module.Category;
import org.union4dev.omni.components.module.ModuleManager;

public class ComponentManager extends ManagerComponent<Component> {
    @Override
    public void initiate() {
        addInstance(EventManager.class, ModuleManager.class, Category.class, BindManager.class, CommandManager.class);
    }

    @Override
    public void registerCallback(Component instance) {
        instance.initiate();
    }
}
