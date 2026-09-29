package org.t1.java.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 *
 * @author DRakovskiy
 */
public class Db {
    private List<String> data = new ArrayList<>();
    private Map<Class, Function<String, Object>> converters = new HashMap<>();

    public void add(Object ob) {
        data.add(ob.toString());
    }

    public <T> T get(int indx, Class<T> clz) {
        return (T) converters.get(clz).apply(data.get(indx));
    }

    public void addConverter(Class clz, Function<String, Object> function) {
        converters.put(clz, function);
    }
}
