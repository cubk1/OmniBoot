package org.union4dev.omni.annotations.features;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.METHOD})
@Retention(value= RetentionPolicy.RUNTIME)
public @interface BindKeyPress {
    int value();
}
