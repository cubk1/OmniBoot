package org.union4dev.omni.components.module;

import org.union4dev.omni.components.management.LabelManagerComponent;
import org.union4dev.omni.elements.module.ModuleCategory;

public class Category extends LabelManagerComponent<ModuleCategory> {

    public static final ModuleCategory COMBAT = new ModuleCategory("Combat");
    public static final ModuleCategory MOVEMENT = new ModuleCategory("Movement");
    public static final ModuleCategory RENDER = new ModuleCategory("Render");
    public static final ModuleCategory PLAYER = new ModuleCategory("Player");
    public static final ModuleCategory WORLD = new ModuleCategory("World");

    @Override
    public void initiate() {
        addValue(COMBAT,MOVEMENT,RENDER,PLAYER,WORLD);
    }
}
