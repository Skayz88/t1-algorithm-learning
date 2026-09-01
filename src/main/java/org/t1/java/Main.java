package org.t1.java;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 0, 0}, // 0 -> 1, 2
                {0, 0, 0, 1, 0}, // 1 -> 3
                {0, 0, 0, 1, 1}, // 2 -> 3, 4
                {0, 0, 0, 0, 1}, // 3 -> 4
                {0, 0, 0, 0, 0}  // 4 ->
        };

        List<int[]> routesOfTravel = adjacencyMatrixToEdgeList(matrix);
        routesOfTravel.forEach(
                line -> System.out.println(java.util.Arrays.toString(line))
        );
//[0, 1]
//[0, 2]
//[1, 3]
//[2, 3]
//[2, 4]
//[3, 4]

        System.out.println(java.util.Arrays.toString(topologicalSort(matrix)));
//[0, 1, 2, 3, 4]
    }

    //Взял из предложенного решения
    public static List<int[]> adjacencyMatrixToEdgeList(int[][] matrix) {
        List<int[]> edges = new ArrayList<>();
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    edges.add(new int[]{i, j});
                }
            }
        }
        return edges;
    }
   //Взял ваше решение оно проще, по алгоритму Тарьяна получаетя сложновато
    public static int[] topologicalSort(int[][] matrix) {
        int n = matrix.length;
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    inDegree[j]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int[] result = new int[n];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for (int j = 0; j < n; j++) {
                if (matrix[node][j] == 1) {
                    inDegree[j]--;
                    if (inDegree[j] == 0) {
                        queue.add(j);
                    }
                }
            }
        }
        return result;
    }

}