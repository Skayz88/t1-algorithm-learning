package org.t1.java;


import org.t1.java.operation.ApplicationBuilder;
import org.t1.java.operation.MinusOperation;
import org.t1.java.operation.PlusOperation;
import org.t1.java.operation.maker.OperationMaker;
import org.t1.java.operation.printer.Printer;
import org.t1.java.operation.reader.DataReader;

public class Main {
    public static void main(String[] args) {

        ApplicationBuilder builder = new ApplicationBuilder();
        builder.add(new PlusOperation());
        builder.add(new MinusOperation());
        builder.add(new Printer());
        builder.add(new DataReader());
        builder.add(new OperationMaker());

        OperationMaker maker = builder.getByType(OperationMaker.class).get(0);
        while (true) {
            maker.make();
        }

    }
}