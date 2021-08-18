package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadobanNumbers {

    static long[] dp = new long[101];

    static void solution() {
        for (int i = 6; i < 101; i++) {
            dp[i] = dp[i - 1] + dp[i - 5];
            System.out.println("dp[" + i +  "] : " + dp[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        int input;
        dp[1] = 1; dp[2] = 1; dp[3] = 1; dp[4] = 2; dp[5] = 2;
        solution();


        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            sb.append(dp[input]).append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}
