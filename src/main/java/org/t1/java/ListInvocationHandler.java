package org.t1.java;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ListInvocationHandler implements InvocationHandler {

    Object object;
    int count;

    public ListInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("add")) count++;
        return method.invoke(object, args);
    }
}
