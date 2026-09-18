package org.t1.java.operation.printer;

import org.t1.java.dto.Model;
import org.t1.java.operation.ApplicationBuilder;
import org.t1.java.operation.maker.Initiable;

import java.util.function.Consumer;

public class Printer implements Consumer<Model>, Initiable {
    @Override
    public void accept(Model model) {
        System.out.println(model.x + model.op + model.y + "=" + model.res);
    }

    @Override
    public void init(ApplicationBuilder applicationBuilder) {

    }
}
