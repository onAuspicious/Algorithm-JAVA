package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ZeroOneTile {

    static int[] dp;

    static int function(int n) {
        for (int i = 3; i < n + 1; i++) {
            dp[i] =(dp[i - 1]+ dp[i - 2]) % 15746;
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        if (input < 3) {
            System.out.println(input);
        } else {
            dp = new int[input + 1];
            dp[1] = 1; dp[2] = 2;
            System.out.println(function(input));
        }
    }
}
