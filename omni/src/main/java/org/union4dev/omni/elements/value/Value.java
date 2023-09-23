package org.union4dev.omni.elements.value;


import org.union4dev.omni.elements.configuration.Configure;

public interface Value<Type> extends Configure {
	Type getValue();
	void setValue(Type value);
}
