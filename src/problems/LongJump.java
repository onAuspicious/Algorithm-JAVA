package problems;

public class LongJump {

    public long solution(int n) {
        int[] dp = new int[n + 1];
        if (n <= 2) return n;

        dp[1] = 1; dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
