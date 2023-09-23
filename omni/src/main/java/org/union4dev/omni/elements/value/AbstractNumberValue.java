package org.union4dev.omni.elements.value;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import org.union4dev.omni.elements.exception.NumberLimitsException;

public abstract class AbstractNumberValue<Self extends AbstractNumberValue<Self, Type>, Type extends Number> extends AbstractValue<Type> {

    @Getter @Setter
    protected Type minimum, maximum, increment;

    protected AbstractNumberValue(String name,Type value,Type minimum,Type maximum,Type increment) {
        super(name,value);
        this.minimum = minimum;
        this.maximum = maximum;
        this.increment = increment;
    }

    @Override
    public void setValue(Type value) {
        if(value == null || inLimits(value)) {
            super.setValue(value);
        } else {
            throw new NumberLimitsException("Unable to set " + value + " (min:" + minimum + ", max:" + maximum + ")");
        }
    }

    protected abstract void add(Type number);

    protected abstract void subtract(Type number);

    protected abstract boolean greaterThan(Type number);

    protected abstract boolean lessThan(Type number);

    protected abstract boolean inLimits(Type number);

    protected boolean greaterOrEquals(Type number) {
        if (greaterThan(number)) {
            return true;
        } else if (number == null && value == null) {
            return false;
        } else {
            return Objects.equals(number, value);
        }
    }

    protected boolean lessOrEquals(Type number) {
        if (lessThan(number)) {
            return true;
        } else if (number == null) {
            return false;
        } else {
            return Objects.equals(number, value);
        }
    }

    public Self minimum(Type minimum) {
        if (value != null && lessThan(minimum)) throw new IllegalArgumentException(
                "minimum is greater than current value: " + value + ", min: " + minimum);

        this.minimum = minimum;
        return self();
    }

    public Self maximum(Type maximum) {
        if (value != null && greaterThan(maximum)) throw new IllegalArgumentException(
                "current value is greater than maximum: " + value + ", max: " + maximum);
        this.maximum = maximum;
        return self();
    }
    protected abstract Self self();

}
