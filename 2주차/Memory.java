import java.util.*;

public class Main {

    static class AdjacencyMatrix {
        int[][] matrix;

        public AdjacencyMatrix(int vertices, int edges) {
            matrix = new int[vertices][vertices];
            Random rand = new Random();
            for (int i = 0; i < edges; i++) {
                int a = rand.nextInt(vertices);
                int b = rand.nextInt(vertices);
                matrix[a][b] = 1;
            }
        }
    }

    static class AdjacencyList {
        List<List<Integer>> list;

        public AdjacencyList(int vertices, int edges) {
            list = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                list.add(new ArrayList<>());
            }
            Random rand = new Random();
            for (int i = 0; i < edges; i++) {
                int a = rand.nextInt(vertices);
                int b = rand.nextInt(vertices);
                list.get(a).add(b);
            }
        }
    }

    public static void main(String[] args) {
        int V = 1000;
        int E = 3000;

        Runtime runtime = Runtime.getRuntime();

        // 인접 행렬 메모리 측정
        runtime.gc(); // 가비지 컬렉션으로 초기화
        long beforeMatrix = runtime.totalMemory() - runtime.freeMemory();
        AdjacencyMatrix matrix = new AdjacencyMatrix(V, E);
        long afterMatrix = runtime.totalMemory() - runtime.freeMemory();
        long matrixMemory = afterMatrix - beforeMatrix;

        // 인접 리스트 메모리 측정
        runtime.gc();
        long beforeList = runtime.totalMemory() - runtime.freeMemory();
        AdjacencyList list = new AdjacencyList(V, E);
        long afterList = runtime.totalMemory() - runtime.freeMemory();
        long listMemory = afterList - beforeList;

        System.out.println("정점 수: " + V + ", 간선 수: " + E);
        System.out.printf("인접 행렬 메모리 사용량: %.2f MB%n", matrixMemory / (1024.0 * 1024.0));
        System.out.printf("인접 리스트 메모리 사용량: %.2f MB%n", listMemory / (1024.0 * 1024.0));
    }
}
