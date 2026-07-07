package org.t1.java.types.matrix;

/**
 *
 * @author DRakovskiy
 */

public record MatrixNode(
        int bandwidth,
        double packetLoss
) {

    @Override
    public String toString() {
        return "{"
                + bandwidth
                + ","
                + packetLoss
                + "}";
    }
}
