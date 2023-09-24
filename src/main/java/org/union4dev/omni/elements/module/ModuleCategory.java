package org.union4dev.omni.elements.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.union4dev.omni.elements.configuration.Label;

@AllArgsConstructor
public class ModuleCategory implements Label {

    @Getter
    private final String name;

}
