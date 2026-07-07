/*
 * VTB Group. Do not reproduce without permission in writing.
 *
 * Copyright (c) 2026 VTB Group. All rights reserved.
 */

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
