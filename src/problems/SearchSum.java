package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            input = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                graph[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        // search sum first
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] += graph[i][j - 1];
            }
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            sb.append(sum(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), graph));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int sum(int x, int y, int a, int b, int[][] graph) {
        int ans = 0;
        for (int i = x; i <= a; i++) {
            ans += graph[i][b] - graph[i][y - 1];
        }
        return ans;
    }
}
