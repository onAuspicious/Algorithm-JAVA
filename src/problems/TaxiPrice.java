package problems;

public class TaxiPrice {

    static int[][] graph;
    int max = 100000000;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n + 1][n + 1];
        int result = max;

        // init graph
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i != j) {
                    graph[i][j] = max;
                }
            }
        }
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = fare[2];
            graph[fare[1]][fare[0]] = fare[2];
        }

        // f-w algorithm
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 0; i < n + 1; i++) {
            result = Math.min(result, graph[s][i] + graph[i][a] + graph[i][b]);
        }

        return result;
    }
}
