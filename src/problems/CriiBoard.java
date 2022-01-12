package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CriiBoard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(work(n));
    }

    public static long work(int n) {
        if (n <= 2) return n;
        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }

        for (int i = 4; i <= n; i++) {
            long add = dp[i - 3];
            for (int j = i; j <= n; j++) {
                dp[j] = Math.max(dp[j], add * (j - i + 2));
            }
        }

        return dp[n];
    }
}