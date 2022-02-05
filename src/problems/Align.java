package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Align {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] line = new int[n];
        int[] dp = new int[n + 1];
        int result = 0;

        for (int i = 0; i < n; i++) {
            line[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < n; i++) {
            int now = line[i];
            dp[now] = dp[now - 1] + 1;
            result = Math.max(result, dp[now]);
        }

        System.out.println(n - result);
    }
}
