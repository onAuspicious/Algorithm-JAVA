package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin1_2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if (now <= k) {
                dp[now]++;
                for (int j = now; j <= k; j++) {
                    dp[j] = dp[j] + dp[j - now];
                }
            }
        }
        System.out.println(dp[k]);
    }
}
