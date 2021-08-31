package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TasteGrape {

    static Integer[] dp;
    static int[] grape;

    static int solution(int n) {
        if (n <= 2) {
            return dp[n];
        }
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(solution(n - 2), solution(n - 3) + grape[n - 1]) + grape[n], solution(n - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n + 1];
        grape = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            grape[i] = Integer.parseInt(br.readLine());
        }
        if (n < 3) {
            System.out.println(Arrays.stream(grape).sum());
        } else {
            dp[0] = 0;
            dp[1] = grape[1];
            dp[2] = grape[1] + grape[2];
            System.out.println(solution(n));
        }
    }
}
