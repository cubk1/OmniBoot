package org.union4dev.omni.elements.value.internal;

import com.google.gson.JsonObject;
import org.union4dev.omni.elements.configuration.Configure;
import org.union4dev.omni.elements.value.AbstractValue;

public class BooleanValue extends AbstractValue<Boolean> {

    public BooleanValue(String name,Boolean value){
        super(name,value);
    }


    @Override
    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("value",value);
        return object;
    }
}
