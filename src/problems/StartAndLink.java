package problems;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StartAndLink {

    static int n;
    static int result = Integer.MAX_VALUE;
    static int[][] board;
    static boolean[] memo;

    static void solution(int now, int count) {
        if (count == n / 2) {
            int start = 0; int link = 0;

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (memo[i] && memo[j]) {
                        start += board[i][j];
                        start += board[j][i];
                    } else if (!memo[i] && !memo[j]) {
                        link += board[i][j];
                        link += board[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(start - link));

            if (result == 0) {
                System.out.println(result);
                System.exit(0);
            }
        } else {
            for (int i = now; i < n; i++) {
                if (!memo[i]) {
                    memo[i] = true;
                    solution(i + 1, count+1);
                    memo[i] = false;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        memo = new boolean[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        solution(0, 0);
        System.out.println(result);
    }
}
