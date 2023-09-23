package org.union4dev.omni.components.management;

import org.union4dev.omni.elements.configuration.Label;
import org.union4dev.omni.elements.exception.ElementNotFoundException;

public abstract class LabelManagerComponent<T extends Label> extends ManagerComponent<T>{

    private final boolean throwException;

    public LabelManagerComponent(boolean throwException){
        this.throwException = throwException;
    }

    public LabelManagerComponent(){
        this(false);
    }

    public T getByName(String name){
        for(T object : getValues()){
            if(object.getName().equalsIgnoreCase(name)){
                return object;
            }
        }
        if(throwException){
            throw new ElementNotFoundException(name);
        }else {
            return null;
        }
    }

    public T getByStrict(String name){
        for(T object : getValues()){
            if(object.getName().equals(name)){
                return object;
            }
        }
        if(throwException){
            throw new ElementNotFoundException(name);
        }else {
            return null;
        }
    }
}
