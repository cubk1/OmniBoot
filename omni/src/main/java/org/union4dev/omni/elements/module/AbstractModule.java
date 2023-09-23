package org.union4dev.omni.elements.module;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.lwjgl.input.Keyboard;
import org.union4dev.omni.Omni;
import org.union4dev.omni.components.event.internal.ToggleEvent;
import org.union4dev.omni.elements.configuration.Configure;
import org.union4dev.omni.elements.configuration.EditableLabel;
import org.union4dev.omni.elements.configuration.Toggleable;
import org.union4dev.omni.elements.event.EventState;
import org.union4dev.omni.elements.value.AbstractValue;

import java.util.ArrayList;
import java.util.List;

@ToString
public abstract class AbstractModule implements EditableLabel,ModuleKeybind, Toggleable, Configure {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private int key;

    @Getter
    private boolean enabled;

    @Getter
    private final ModuleCategory category;

    @Getter
    private final List<AbstractValue<?>> values;

    public AbstractModule(String name, ModuleCategory category){
        this(name,category, Keyboard.KEY_NONE);
    }

    public AbstractModule(String name, ModuleCategory category, int key){
        this.name = name;
        this.key = key;
        this.category = category;
        this.enabled = false;
        this.values = new ArrayList<>();
    }

    public void addValues(AbstractValue<?>... o) {
        for (AbstractValue<?> v : o) {
            if (!values.contains(v)) values.add(v);
        }
    }

    @Override
    public void setEnable(boolean enable) {
        ToggleEvent event = new ToggleEvent(this,enable);

        Omni.getInstance().getEventManager().call(event);

        if(event.isCancelled()) return;

        if(this.enabled != enable){
            this.enabled = enable;
            if(enable){
                onEnable(EventState.PRE);
                Omni.getInstance().getEventManager().register(this);
                onEnable(EventState.POST);
            }else{
                onDisable(EventState.PRE);
                Omni.getInstance().getEventManager().unregister(this);
                onDisable(EventState.POST);
            }
        }
    }

    @Override
    public void toggle() {

    }

    @Override
    public void onEnable(EventState state) {

    }

    @Override
    public void onDisable(EventState state) {

    }

    @Override
    public JsonObject toJson() {
        JsonObject object = new JsonObject();
        JsonObject values = new JsonObject();
        object.addProperty("enabled",enabled);
        object.addProperty("key",key);
        for(AbstractValue<?> value : getValues()){
            values.add(value.getName(),value.toJson());
        }
        object.add("values",values);
        return object;
    }

    @Override
    public void applyJson(JsonObject object) {
        setEnable(Configure.getValue(object,"enabled", false));
        setKey(Configure.getValue(object,"key",Keyboard.KEY_NONE));
        if(object.has("values")){
            JsonObject values = object.get("values").getAsJsonObject();
            for(AbstractValue<?> value : getValues()){
                if(values.has(value.getName()))
                    value.applyJson(values.getAsJsonObject(value.getName()));
            }
        }
    }
}
