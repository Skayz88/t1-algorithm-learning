/*
 * VTB Group. Do not reproduce without permission in writing.
 *
 * Copyright (c) 2026 VTB Group. All rights reserved.
 */

package org.t1.java.types.matrix;

import java.util.Arrays;

/**
 *
 * @author DRakovskiy
 */
public class MatrixGraph {

    public static MatrixNode[][] matrix;

    static {
        matrix = new MatrixNode[6][6];
        initMatrix();
    }

    private static void initMatrix() {
        addRelation(0, 1, 1500, 0.9);
        addRelation(0, 2, 2000, 0.1);
        addRelation(0, 3, 1000, 0.5);
        addRelation(1, 4, 1500, 0.6);
        addRelation(2, 4, 900, 0.05);
        addRelation(2, 5, 500, 0.2);
        addRelation(3, 4, 2500, 0.01);
        addRelation(4, 5, 300, 0.85);
    }

    private static void addRelation(int on, int to, int bandwidth, double packetLoss) {
        matrix[on][to] = new MatrixNode(bandwidth, packetLoss);
    }

    public static void printMatrix() {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ":" + Arrays.toString(matrix[i]));
        }
    }

    public static MatrixNode[][] matrixNet() {
        return matrix;
    }


}
