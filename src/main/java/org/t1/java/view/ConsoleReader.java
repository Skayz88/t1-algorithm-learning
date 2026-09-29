package org.t1.java.view;

import org.t1.java.viewmodel.CalculatorViewModel;
import org.t1.java.dto.Data;

import java.util.Scanner;

public class ConsoleReader{
    private final CalculatorViewModel calculatorViewModel;

    public ConsoleReader(CalculatorViewModel calculatorViewModel) {
        this.calculatorViewModel = calculatorViewModel;
    }

    public void read() {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String op = scanner.next();
            Data<Integer> data = new Data<>(x, y, op);
            calculatorViewModel.perform(data);
        }
    }
}
