package org.t1.java.types.list;

/**
 *
 * @author DRakovskiy
 */
public record NetworkPoint(
        GraphNode graphNode,
        int bandwidth,
        double packetLoss
) {

    @Override
    public String toString() {
        return "{"
                + "node= " + graphNode.name
                + ", bandwidth=" + bandwidth
                + ", packetLoss=" + packetLoss
                + '}';
    }
}
