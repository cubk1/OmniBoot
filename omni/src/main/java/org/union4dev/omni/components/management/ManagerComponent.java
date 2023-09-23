package org.union4dev.omni.components.management;

import lombok.Getter;
import org.union4dev.omni.components.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class ManagerComponent<T> extends Component {
    @Getter
    protected List<T> values = new ArrayList<>();

    @SafeVarargs
    public final void addInstance(Class<?>... classes) {
        for (Class<?> aClass : classes) {
            try {
                T instance = (T) aClass.getDeclaredConstructor().newInstance();
                registerCallback(instance);
                values.add(instance);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void registerCallback(T instance){}

    @SafeVarargs
    public final void addValue(T... o){
        this.values.addAll(Arrays.asList(o));
    }

    @SuppressWarnings("unchecked cast")
    public <A extends T> A getByClass(Class<A> clazz) {
        return (A) values.stream().filter(o -> o.getClass() == clazz).findFirst().orElse(null);
    }
}
