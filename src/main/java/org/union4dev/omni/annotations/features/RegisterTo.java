package org.union4dev.omni.annotations.features;

import org.union4dev.omni.components.management.ManagerComponent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface RegisterTo {
    Class<? extends ManagerComponent<?>> value();
}
