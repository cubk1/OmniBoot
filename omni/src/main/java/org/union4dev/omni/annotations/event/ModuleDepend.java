package org.union4dev.omni.annotations.event;

import org.union4dev.omni.elements.module.AbstractModule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(value=RetentionPolicy.RUNTIME)
public @interface ModuleDepend {
    Class<? extends AbstractModule> value();
}
