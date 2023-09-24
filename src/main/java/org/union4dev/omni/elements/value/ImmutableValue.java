package org.union4dev.omni.elements.value;

public interface ImmutableValue<Type> extends Value<Type> {
    @Override
	default void setValue(Type value) {
        throw new UnsupportedOperationException("Tried to change immutable property");
    }
}
