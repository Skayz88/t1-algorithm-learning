package org.t1.java;

import org.t1.java.model.Calculator;
import org.t1.java.viewmodel.CalculatorViewModel;
import org.t1.java.view.ConsoleWriter;
import org.t1.java.view.ConsoleReader;


public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.addOperation("+",data-> data.getX()+ data.getY());
        calculator.addOperation("-",data-> data.getX()- data.getY());

        CalculatorViewModel calculatorViewModel = new CalculatorViewModel(calculator);
        ConsoleReader reader = new ConsoleReader(calculatorViewModel);
        ConsoleWriter writer = new ConsoleWriter(calculatorViewModel);

        reader.read();
    }



}