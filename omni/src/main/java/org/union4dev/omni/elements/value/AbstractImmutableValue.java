package org.union4dev.omni.elements.value;


public abstract class AbstractImmutableValue<T> extends AbstractValue<T> implements ImmutableValue<T> {
    public AbstractImmutableValue(String name, T value) {
        super(name, value);
    }

    @Override
    public final void setValue(T value) {
        super.setValue(value);
    }
}
