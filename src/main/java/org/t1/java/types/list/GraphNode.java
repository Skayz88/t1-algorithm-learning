/*
 * VTB Group. Do not reproduce without permission in writing.
 *
 * Copyright (c) 2026 VTB Group. All rights reserved.
 */

package org.t1.java.types.list;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DRakovskiy
 */
public class GraphNode {
    public String name;
    public List<NetworkPoint> networkThisNode;

    public GraphNode(String name) {
        this.name = name;
        networkThisNode = new ArrayList<>();
    }

    public void addRoute(GraphNode point,  int bandwidth, double packetLoss) {
        NetworkPoint newRoute = new NetworkPoint(point, bandwidth, packetLoss);
        networkThisNode.add(newRoute);
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", toNode=" + networkThisNode +
                '}';
    }

}
