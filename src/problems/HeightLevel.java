package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HeightLevel {

    static int STANDARD = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] graph = new int[n + 1][n + 1];
        int result = 0;

        for (int i = 0; i <= n; i++) {
            Arrays.fill(graph[i], STANDARD);
            graph[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (checkLevel(graph, i, n)) result++;
        }

        System.out.println(result);
        br.close();
    }

    public static boolean checkLevel(int[][] graph, int num, int n) {
        for (int i = 1; i <= n; i++) {
            if (graph[i][num] >= STANDARD && graph[num][i] >= STANDARD) {
                return false;
            }
        }
        return true;
    }
}
