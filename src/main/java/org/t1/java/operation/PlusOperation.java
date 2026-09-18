package org.t1.java.operation;

import org.t1.java.operation.maker.Initiable;

import java.util.function.BinaryOperator;

public class PlusOperation implements BinaryOperator<Integer>, Initiable {
    @Override
    public Integer apply(Integer x, Integer y) {
        return x + y;
    }

    @Override
    public void init(ApplicationBuilder applicationBuilder) {

    }
    @Override
    public String toString() {
        return "+";
    }
}
