package org.t1.java.types.list;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author DRakovskiy
 */
public class NetworkGraph {

    public static Map<String, GraphNode> nodeNetwork;
    public static GraphNode graphNetwork;

    static {
        nodeNetwork = initNodeNet();
        graphNetwork = nodeNetwork.get("A");
    }

    private static Map<String, GraphNode> initNodeNet() {

        GraphNode A = new GraphNode("A");
        GraphNode B = new GraphNode("B");
        GraphNode C = new GraphNode("C");
        GraphNode D = new GraphNode("D");
        GraphNode E = new GraphNode("E");
        GraphNode F = new GraphNode("F");

        A.addRoute(B, 1500, 0.9);
        A.addRoute(C, 2000, 0.1);
        A.addRoute(D, 1000, 0.5);
        B.addRoute(F, 1500, 0.6);
        C.addRoute(E, 900, 0.05);
        C.addRoute(F, 500, 0.2);
        D.addRoute(E, 2500, 0.01);
        E.addRoute(F, 300, 0.85);

        return Map.of(
                A.name, A,
                B.name, B,
                C.name, C,
                D.name, D,
                E.name, E,
                F.name, F
        );
    }

    public static void printNetwork(String startPoint) {
        if (nodeNetwork.containsKey(startPoint))
            System.out.println(nodeNetwork.get(startPoint).toString());
    }

    public static void printNetwork() {
        Set<String> nameNode = nodeNetwork.keySet();
        nameNode.stream()
                .sorted()
                .forEach(
                        NetworkGraph::printNetwork
                );
    }

    public static GraphNode nodeNet() {
        return graphNetwork;
    }


}
