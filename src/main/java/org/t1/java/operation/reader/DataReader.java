package org.t1.java.operation.reader;

import org.t1.java.dto.Model;
import org.t1.java.operation.ApplicationBuilder;
import org.t1.java.operation.maker.Initiable;

import java.util.Scanner;
import java.util.function.Supplier;

public class DataReader implements Supplier<Model>, Initiable {

    @Override
    public Model get() {
        Model model = new Model();
        Scanner sc = new Scanner(System.in);
        model.op = sc.next();
        model.x = sc.nextInt();
        model.y = sc.nextInt();
        return model;
    }

    @Override
    public void init(ApplicationBuilder applicationBuilder) {

    }
}
