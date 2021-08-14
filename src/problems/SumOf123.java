package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOf123 {

    static int[] dp;

    public static int solution(int num) {
        dp = new int[num+1];
        if (num <= 2) {
            return num;
        } else {
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            return dfs(num);
        }
    }

    public static int dfs(int num) {
        if (dp[num] != 0) {
            return dp[num];
        } else {
            dp[num] = dfs(num - 1) + dfs(num - 2) + dfs(num - 3);
            return dp[num];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int input;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            sb.append(solution(input)).append('\n');
        }
        System.out.println(sb);
    }
}
