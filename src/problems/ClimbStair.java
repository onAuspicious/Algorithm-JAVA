package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ClimbStair {

    static int[] arr;
    static Integer[] dp;

    static int solution(int n) {
        if (n <= 2) {
            return dp[n];
        }
        if (dp[n] == null) {
            dp[n] = Math.max(solution(n - 2), solution(n - 3) + arr[n - 1]) + arr[n];
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i < n + 1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n < 3) {
            System.out.println(Arrays.stream(arr).sum());
        } else {
            dp[0] = arr[0];
            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];
            System.out.println(solution(n));
        }
    }
}
