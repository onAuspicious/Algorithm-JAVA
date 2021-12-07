package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DownhillRoad {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n, m;
    static int[][] dp, board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int result = 0;
        board = new int[n][m];
        dp = new int[n][m];

        // init dp -1 : 0 이면 계속 진행하게 됩니다.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[n - 1][m - 1] = 1;

        // init graph
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(dfs(0, 0));
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] > -1) {
            return dp[x][y];
        }

        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && board[x][y] > board[tmpx][tmpy]) {
                cnt += dfs(tmpx, tmpy);
            }
        }

        dp[x][y] = cnt;
        return dp[x][y];
    }
}
