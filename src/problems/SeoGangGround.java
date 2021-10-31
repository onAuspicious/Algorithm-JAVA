package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SeoGangGround {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] items = new int[n + 1];
        int[][] graph = new int[n + 1][n + 1];
        int distance = Integer.parseInt(input[1]);
        String[] itemInput = br.readLine().split(" ");

        for (int i = 1; i < items.length; i++) {
            items[i] = Integer.parseInt(itemInput[i - 1]);
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = 1000000000;
            }
            graph[i][i] = 0;
        }

        for (int i = 0; i < Integer.parseInt(input[2]); i++) {
            String[] info = br.readLine().split(" ");
            int a = Integer.parseInt(info[0]);
            int b = Integer.parseInt(info[1]);
            int d = Integer.parseInt(info[2]);
            graph[a][b] = d;
            graph[b][a] = d;
        }

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                }
            }
        }

        int result = 0;

        for (int i = 1; i < n + 1; i++) {
            int cnt = 0;
            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] <= distance) {
                    cnt += items[j];
                }
            }
            result = Math.max(result, cnt);
        }

        System.out.println(result);
    }
}
