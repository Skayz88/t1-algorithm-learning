/*
 * VTB Group. Do not reproduce without permission in writing.
 *
 * Copyright (c) 2026 VTB Group. All rights reserved.
 */

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
