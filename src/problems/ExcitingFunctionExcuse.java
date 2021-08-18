package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExcitingFunctionExcuse {

    static int[][][] dp = new int[21][21][21];

    static int function(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if (a > 20 || b > 20 || c > 20) {
            return function(20, 20, 20);
        }
        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }
        if (a < b && b < c) {
            dp[a][b][c] = function(a, b, c - 1) + function(a, b - 1, c - 1) - function(a, b - 1, c);
        } else {
            dp[a][b][c] = function(a - 1, b, c) + function(a - 1, b - 1, c) + function(a - 1, b, c - 1) - function(a - 1, b - 1, c - 1);
        }
        return dp[a][b][c];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        dp[0][0][0] = 1;

        while (true) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if (a == -1 && b == -1 && c == -1) {
                break;
            } else {
                sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                        .append(") = ").append(function(a, b, c)).append('\n');
            }
        }
        System.out.println(sb);
    }
}
