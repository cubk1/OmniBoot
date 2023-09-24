package org.union4dev.omni.elements.configuration;

import com.google.gson.JsonObject;

public interface Configure {
    void applyJson(JsonObject object);
    JsonObject toJson();
    @SuppressWarnings("unchecked")
    static <A> A getValue(JsonObject object, String value, A def) {
        if(object.has(value))
            return (A) object.get(value);
        return def;
    }
}
