package org.t1.java;

import org.t1.java.types.list.GraphNode;
import org.t1.java.types.list.NetworkGraph;
import org.t1.java.types.list.NetworkPoint;
import org.t1.java.types.matrix.MatrixGraph;
import org.t1.java.types.matrix.MatrixNode;
import org.t1.java.types.maxmin.Result;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author DRakovskiy
 */

public class Main {
    public static void main(String[] args) {

        List<Integer> lst = List.of(5, 4, 2, 1, 3);
        Result res = findMinMaxInTask(lst);
        if (Objects.nonNull(res))
            System.out.println("Max= " + res.max() + " min= " + res.min());

        res = findMinMaxFast(lst);
        if (Objects.nonNull(res))
            System.out.println("Max= " + res.max() + " min= " + res.min());

    }

    public static Result findMinMaxFast(List<Integer> lst) {
        if (Objects.isNull(lst) || lst.isEmpty()) return null;
        Iterator<Integer> it = lst.iterator();
        int min = it.next();
        int max = min;

        while (it.hasNext()) {
            int a = it.next();
            if (it.hasNext()) {
                int b = it.next();
                if (a < b) {
                    if (a < min) min = a;
                    if (b > max) max = b;
                } else {
                    if (b < min) min = b;
                    if (a > max) max = a;

                }
            } else {
                if (a < min) min = a;
                if (a > max) max = a;
            }
        }
        return new Result(min, max);
    }

    public static Result findMinMaxInTask(List<Integer> lst) {
        if (Objects.isNull(lst) || lst.isEmpty()) return null;
        int min = lst.get(0);
        int max = lst.get(0);
        for (int i = 1; i < lst.size(); i++) {
            if (min > lst.get(i)) min = lst.get(i);
            if (max < lst.get(i)) max = lst.get(i);
        }
        return new Result(min, max);
    }


    private static void startFirstStep() {

        //        MatrixGraph.printMatrix();
        //        NetworkGraph.printNetwork();
//        System.out.println("--------------------------------------------------");

        MatrixNode[][] matrix = MatrixGraph.matrixNet();
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ":" + Arrays.toString(matrix[i]));
        }

        System.out.println("****************************************************");

        GraphNode graphNode = NetworkGraph.nodeNet();
        print(graphNode, new HashSet<>());
    }

    private static void print(GraphNode node, Set<GraphNode> visited) {
        if (Objects.isNull(node) || visited.contains(node)) return;

        visited.add(node);
        System.out.println(node.toString());
        for (NetworkPoint point : node.networkThisNode) {
            print(point.graphNode(), visited);
        }
    }
    /*
0:[null, {1500,0.9}, {2000,0.1}, {1000,0.5}, null, null]
1:[null, null, null, null, {1500,0.6}, null]
2:[null, null, null, null, {900,0.05}, {500,0.2}]
3:[null, null, null, null, {2500,0.01}, null]
4:[null, null, null, null, null, {300,0.85}]
5:[null, null, null, null, null, null]
****************************************************
{name='A', toNode=[{node= B, bandwidth=1500, packetLoss=0.9}, {node= C, bandwidth=2000, packetLoss=0.1}, {node= D, bandwidth=1000, packetLoss=0.5}]}
{name='B', toNode=[{node= F, bandwidth=1500, packetLoss=0.6}]}
{name='F', toNode=[]}
{name='C', toNode=[{node= E, bandwidth=900, packetLoss=0.05}, {node= F, bandwidth=500, packetLoss=0.2}]}
{name='E', toNode=[{node= F, bandwidth=300, packetLoss=0.85}]}
{name='D', toNode=[{node= E, bandwidth=2500, packetLoss=0.01}]}
     */
}