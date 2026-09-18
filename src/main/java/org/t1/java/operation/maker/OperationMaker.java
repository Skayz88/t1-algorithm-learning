package org.t1.java.operation.maker;

import org.t1.java.dto.Model;
import org.t1.java.operation.ApplicationBuilder;

import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class OperationMaker implements Initiable {
    Supplier<Model> datareader;
    Consumer<Model> printer;
    Map<String, BinaryOperator<Integer>> operations;

    public void make() {
        Model model = datareader.get();
        model.res = operations
                .get(model.op)
                .apply(model.x, model.y);

        printer.accept(model);
    }

    @Override
    public void init(ApplicationBuilder applicationBuilder) {
        datareader=applicationBuilder.getByType(Supplier.class).get(0);
        printer=applicationBuilder.getByType(Consumer.class).get(0);
        operations=applicationBuilder.getByType(BinaryOperator.class).stream()
                .collect(Collectors.toMap(x->x.toString(),x->x));
    }
}
