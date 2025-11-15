package org.yogiyo;

import java.util.*;

public class Main {

    static class AdjacencyMatrix {
        int[][] matrix;
        int V;

        public AdjacencyMatrix(int vertices, int edges) {
            this.V = vertices;
            matrix = new int[V][V];
            Random rand = new Random();
            for (int i = 0; i < edges; i++) {
                int a = rand.nextInt(V);
                int b = rand.nextInt(V);
                matrix[a][b] = 1;
            }
        }

        boolean hasEdge(int a, int b) {
            return matrix[a][b] == 1;
        }
    }

    static class AdjacencyList {
        List<List<Integer>> list;
        int V;

        public AdjacencyList(int vertices, int edges) {
            this.V = vertices;
            list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());

            Random rand = new Random();
            for (int i = 0; i < edges; i++) {
                int a = rand.nextInt(V);
                int b = rand.nextInt(V);
                list.get(a).add(b);
            }
        }

        boolean hasEdge(int a, int b) {
            return list.get(a).contains(b);  // 리스트 탐색 O(deg(a))
        }
    }

    public static void main(String[] args) {
        int V = 10000;
        int E = 30000;

        AdjacencyMatrix matrix = new AdjacencyMatrix(V, E);
        AdjacencyList adjList = new AdjacencyList(V, E);

        int testA = 1234;
        int testB = 5678;

        // -------- 인접 행렬 테스트 --------
        long start = System.nanoTime();
        boolean m = matrix.hasEdge(testA, testB);
        long end = System.nanoTime();
        System.out.println("인접 행렬 간선 탐색 시간: " + (end - start) + " ns");

        // -------- 인접 리스트 테스트 --------
        start = System.nanoTime();
        boolean l = adjList.hasEdge(testA, testB);
        end = System.nanoTime();
        System.out.println("인접 리스트 간선 탐색 시간: " + (end - start) + " ns");
    }
}