package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FunctionFibo {

    static int[] dp;

    static int fibo(int i) {
        if (i == 0) {
            return 0;
        } else if (i == 1) {
            return 1;
        }
        if (dp[i] == 0) {
            dp[i] = fibo(i - 1) + fibo(i - 2);
        }
        return dp[i];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] res = new int[n];
        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            res[i] = Integer.parseInt(br.readLine());
            maximum = Math.max(res[i], maximum);
        }

        dp = new int[maximum + 1];
        dp[1] = 1;
        fibo(maximum);

        for (int i = 0; i < n; i++) {
            if (res[i] == 0) {
                sb.append(1).append(" ").append(0).append("\n");
            } else {
                sb.append(dp[res[i]-1]).append(" ").append(dp[res[i]]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
