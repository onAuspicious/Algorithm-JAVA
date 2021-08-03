package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SugarDelivery {

    public int solution(int N) {
        int[] dp = new int[N + 1];
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 3; i < N + 1; i++) {
            if (dp[i] == 0) {
                continue;
            }
            if (i + 3 < N + 1) {
                if (dp[i + 3] != 0) {
                    dp[i + 3] = Math.min(dp[i] + 1, dp[i + 3]);
                } else {
                    dp[i + 3] = dp[i] + 1;
                }
            }
            if (i + 5 < N + 1) {
                if (dp[i + 5] != 0) {
                    dp[i + 5] = Math.min(dp[i] + 1, dp[i + 5]);
                } else {
                    dp[i + 5] = dp[i] + 1;
                }
            }
        }
        if (dp[N] == 0) {
            return -1;
        } else {
            return dp[N];
        }
    }

    public static void main(String[] args) throws IOException {
        SugarDelivery main = new SugarDelivery();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 5) {
            if (N == 4) {
                System.out.println(-1);
            } else if (N == 3) {
                System.out.println(1);
            }
        } else {
            System.out.println(main.solution(N));
        }
    }
}
