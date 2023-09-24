package org.union4dev.omni.elements.value.internal;

import com.google.gson.JsonObject;
import lombok.Getter;
import org.union4dev.omni.Omni;
import org.union4dev.omni.components.event.internal.InvalidModeEvent;
import org.union4dev.omni.elements.configuration.Configure;
import org.union4dev.omni.elements.value.AbstractValue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ModeValue extends AbstractValue<String> {

    @Getter
    private final String[] modes;

    public ModeValue(String name,String current, String[] modes) {
        super(name,current);
        this.modes = modes;
    }

    public boolean isCurrentMode(String name){
        return getValue().equals(name);
    }

    public int getCurrentModeIndex() {
        int index = 0;
        for (String s : modes) {
            if (s.equalsIgnoreCase(value)) {
                return index;
            }
            index++;
        }
        return index;
    }

    @Override
    public void applyJson(JsonObject object) {
        String mode = Configure.getValue(object,"value",value);
        List<String> modeList = Collections.singletonList(mode);
        if(modeList.contains(mode)){
            setValue(mode);
        }else {
            Omni.getInstance().getEventManager().call(new InvalidModeEvent(this,mode));
        }
    }

    @Override
    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        object.addProperty("value",value);
        return object;
    }
}
