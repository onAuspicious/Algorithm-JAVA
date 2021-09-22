package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KevinBacon {

    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] graph = new int[n + 1][n + 1];
        int a; int b;

        // init
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            String[] split = br.readLine().split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        // F W
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int result = 0;
        int value = INF;

        for (int i = 1; i < n + 1; i++) {
            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                sum += graph[i][j];
            }
            if (sum < value) {
                value = sum;
                result = i;
            }
        }
        System.out.println(result);
    }
}
