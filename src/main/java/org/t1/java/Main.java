package org.t1.java;


import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(List.of(3, 4, 5));
        ListInvocationHandler handler = new ListInvocationHandler(new ArrayList<>(List.of(3, 4, 5)));
        lst = (List<Integer>) Proxy.newProxyInstance(lst.getClass().getClassLoader(),
                lst.getClass().getInterfaces(),
                handler);
        System.out.println(lst);
        lst.add(11);
        lst.add(22);
        lst.add(33);
        System.out.println(lst);
        System.out.println(handler.count);

    }



}