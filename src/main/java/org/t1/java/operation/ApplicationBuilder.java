package org.t1.java.operation;

import org.t1.java.operation.maker.Initiable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationBuilder {
    private final List<Object> objects = new ArrayList<>();

    public ApplicationBuilder add(Initiable object) {
        object.init(this);
        objects.add(object);
        return this;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> getByType(Class<T> type) {
        return (List<T>) objects.stream()
                .filter(x -> classEquals(type,x.getClass()))
                .toList();
    }
    private boolean classEquals(Class need, Class have){
        if(need==have) return true;
        return Arrays.stream(have.getInterfaces())
                .anyMatch(x->x==need);
    }

    public List<Object> getObjects() {
        return objects;
    }
}
