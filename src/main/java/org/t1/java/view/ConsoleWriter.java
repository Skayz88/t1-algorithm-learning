package org.t1.java.view;

import org.t1.java.viewmodel.CalculatorViewModel;
import org.t1.java.dto.Data;

public class ConsoleWriter {
    private final CalculatorViewModel calculatorViewModel;

    public ConsoleWriter(CalculatorViewModel calculatorViewModel) {
        this.calculatorViewModel = calculatorViewModel;
        calculatorViewModel.subscribe("operation complete", this::write);
    }

    public void write() {
        Data d=calculatorViewModel.getCurData();
        System.out.println(d.getX()+d.operation()+d.getY()+"="+d.getRes());
    }
}
