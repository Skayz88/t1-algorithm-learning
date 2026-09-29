package org.t1.java;


import org.t1.java.db.Db;

public class Main {
    public static void main(String[] args) {
        Db dataBase = new Db();
        dataBase.add(4);
        dataBase.add("4");
        dataBase.add("a");

        dataBase.addConverter(Integer.class, Integer::parseInt);
        dataBase.addConverter(String.class, x -> x);

        String val1 = dataBase.get(0, String.class);
        Integer val2 = dataBase.get(0, Integer.class);
        System.out.println(val1);
        System.out.println(val2);

        val1 = dataBase.get(1, String.class);
        val2 = dataBase.get(1, Integer.class);
        System.out.println(val1);
        System.out.println(val2);

        val1 = dataBase.get(2, String.class);
        System.out.println(val1);
    }



}