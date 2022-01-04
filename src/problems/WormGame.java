package problems;

import java.util.Arrays;

public class WormGame {

    int[][] dp;
    int w, h;
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] R) {
        w = R[0].length;
        h = R.length;
        dp = new int[h][w];
        int result = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                result = Math.max(result, dfs(R, i, j));
            }
        }

        for (int[] ints : dp) {
            for (int i : ints) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();

        return result + 1;
    }

    public int dfs(int[][] R, int x, int y) {
        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        for (int i = 0; i < 4; i++) {
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            if (0 <= tmpx && tmpx < h && 0 <= tmpy && tmpy < w && R[x][y] < R[tmpx][tmpy]) {
                dp[x][y] = Math.max(dfs(R, tmpx, tmpy) + 1, dp[x][y]);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {
        WormGame wormGame = new WormGame();
        int solution = wormGame.solution(new int[][]{{3, 9, 2, 7}, {10, 6, 8, 4}, {1, 4, 9, 10}, {5, 7, 8, 4}});
//        int solution = wormGame.solution(new int[][]{{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}});
        System.out.println(solution);
    }
}
