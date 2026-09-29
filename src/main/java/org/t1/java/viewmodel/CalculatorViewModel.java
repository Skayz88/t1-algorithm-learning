package org.t1.java.viewmodel;

import org.t1.java.base.Observer;
import org.t1.java.dto.Data;
import org.t1.java.model.Calculator;

public class CalculatorViewModel extends Observer {
    private Calculator calculator;
    private Data<Integer> data;

    public CalculatorViewModel(Calculator calculator) {
        this.calculator = calculator;
        calculator.subscribe("result", this::updateResult);
    }

    private void updateResult() {
        data.setRes(calculator.getResult());
        notify("operation complete");
    }

    public Data getCurData() {
        return data;
    }

    public void perform(Data<Integer> data) {
        this.data= new Data<>(data);
        calculator.makeOperation(data);
    }

}
