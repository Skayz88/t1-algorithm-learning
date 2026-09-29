package org.t1.java.model;

import org.t1.java.dto.Data;
import org.t1.java.base.Observer;

import java.util.HashMap;
import java.util.Map;

public class Calculator extends Observer {
    private Map<String, Operation<Integer>> operationMap = new HashMap<>();
    private int result;

    public void makeOperation(Data<Integer> data) {
        result=operationMap.get(data.operation()).perform(data);
        notify("result");
    }

    public void addOperation(String name, Operation<Integer> operation){
        operationMap.put(name,operation);
    }

    public int getResult() {
        return result;
    }
}
