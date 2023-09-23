package org.union4dev.omni.elements.value.internal;

import com.google.gson.JsonObject;
import org.union4dev.omni.elements.value.AbstractNumberValue;

public class NumberValue extends AbstractNumberValue<NumberValue,Double> {

    protected NumberValue(String name, Double value, Double minimum, Double maximum, Double increment) {
        super(name, value, minimum, maximum, increment);
    }

    @Override
    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("value",value);
        return object;
    }

    protected void add(Double number) {
        this.value += number;
    }

    @Override
    protected void subtract(Double number) {
        this.value -= number;
    }

    @Override
    protected boolean greaterThan(Double number) {
        if (number == null) {
            return value != null;
        } else if (value == null) {
            return true;
        } else {
            return value > number;
        }
    }

    @Override
    protected boolean lessThan(Double number) {
        if (number == null) {
            return false;
        } else if (value == null) {
            return true;
        } else {
            return value < number;
        }
    }

    @Override
    protected boolean inLimits(Double number) {
        return (minimum == null || number >= minimum) && (maximum == null || number <= maximum);
    }

    @Override
    protected NumberValue self() {
        return this;
    }

}
