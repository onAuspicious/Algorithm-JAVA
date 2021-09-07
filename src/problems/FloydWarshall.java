package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloydWarshall {

    static int max = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        int[][] graph = new int[n + 1][n + 1];
        int x; int y; int k;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                graph[i][j] = max;
            }
        }

        for (int i = 0; i < line; i++) {
            String[] input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            graph[x][y] = Math.min(k, graph[x][y]);
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int l = 0; l < n + 1; l++) {
                    if (j != l) {
                        graph[j][l] = Math.min(graph[j][l], graph[j][i] + graph[i][l]);
                    }
                }
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] == max) {
                    sb.append(0).append(' ');
                } else {
                    sb.append(graph[i][j]).append(' ');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
