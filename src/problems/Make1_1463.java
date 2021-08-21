package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Make1_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[num + 1];
        dp[0] = -1;

        for (int i = 1; i < num + 1; i++) {
            if (dp[i] != 0) {
                if (dp[i] > dp[i - 1] + 1) {
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            for (int j = i * 2; j < num + 1; j *= 2) {
                if (dp[j] == 0) {
                    dp[j] = dp[j / 2] + 1;
                } else {
                    dp[j] = Math.min(dp[j / 2] + 1, dp[j]);
                }
            }
            for (int j = i * 3; j < num + 1; j *= 3) {
                if (dp[j] == 0) {
                    dp[j] = dp[j / 3] + 1;
                } else {
                    dp[j] = Math.min(dp[j / 3] + 1, dp[j]);
                }
            }
        }
        System.out.println(dp[num]);
    }
}
