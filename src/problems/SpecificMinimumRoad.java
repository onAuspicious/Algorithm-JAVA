package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SpecificMinimumRoad {

    static int max = 300000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NAndM = br.readLine().split(" ");
        int n = Integer.parseInt(NAndM[0]);
        int m = Integer.parseInt(NAndM[1]);
        int[][] graph = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = max;
            }
        }

        for (int i = 0; i < n + 1; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int d = Integer.parseInt(input[2]);
            graph[x][y] = d;
            graph[y][x] = d;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        String[] nodes = br.readLine().split(" ");
        int a = Integer.parseInt(nodes[0]);
        int b = Integer.parseInt(nodes[1]);

        int route1 = graph[1][a] + graph[a][b] + graph[b][n];
        int route2 = graph[1][b] + graph[b][a] + graph[a][n];
        int result = Math.min(route1, route2);
        if (result >= max) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
