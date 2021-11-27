package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Travel {

    static int n, m, k;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        int[][] flight = new int[n + 1][n + 1];

        for (int i = 0; i < k; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int meal = Integer.parseInt(input[2]);
            if (a > b) continue;
            flight[a][b] = Math.max(flight[a][b], meal);
        }

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) Arrays.fill(dp[i], -1);
        dp[1][1] = 0;

        for (int i = 1; i <= n; i++) {
            int depth = Math.min(i, m - 1);
            for (int j = 1; j <= depth; j++) {
                if (dp[j][i] == -1) continue;
                for (int l = i + 1; l <= n; l++) {
                    if (flight[i][l] == 0) continue;
                    dp[j+1][l] = Math.max(dp[j+1][l], dp[j][i] + flight[i][l]);
                }
            }
        }

        for (int i = 1; i <= m; i++) {
            result = Math.max(result, dp[i][n]);
        }
        System.out.println(result);
    }
}
