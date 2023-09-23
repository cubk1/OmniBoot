package org.union4dev.omni.elements.value;

import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.union4dev.omni.Omni;
import org.union4dev.omni.components.event.internal.SettingEvent;
import org.union4dev.omni.elements.configuration.Configure;
import org.union4dev.omni.elements.configuration.Label;

@AllArgsConstructor
public abstract class AbstractValue<Type> implements Value<Type>, Label {
	@Getter
	protected String name;
	@Getter
	protected Type value;

	@Override
	public void setValue(Type value) {
		SettingEvent<Type> event = new SettingEvent<>(this,value);
		Omni.getInstance().getEventManager().call(event);
		if(event.isCancelled()) return;
		this.value = event.getNewValue();
	}

	@Override
	public void applyJson(JsonObject object) {
		setValue(Configure.getValue(object,"value",value));
	}

}
