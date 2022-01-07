package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BreakWallMove {

    static int n, m, k;
    static int[][] board;
    static int[][][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static class Node {
        int x;
        int y;
        int k;

        public Node(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        k = Integer.parseInt(input[2]);
        board = new int[n][m];
        visit = new int[k + 1][n][m];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visit[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(0, 0, k));
        visit[k][0][0] = 1;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();

            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m) {
                    if (board[tmpx][tmpy] == 1 && now.k > 0 && visit[now.k - 1][tmpx][tmpy] > visit[now.k][now.x][now.y] + 1) {
                        dq.offerLast(new Node(tmpx, tmpy, now.k - 1));
                        visit[now.k - 1][tmpx][tmpy] = visit[now.k][now.x][now.y] + 1;
                    }
                    if (board[tmpx][tmpy] == 0 && visit[now.k][tmpx][tmpy] > visit[now.k][now.x][now.y] + 1) {
                        dq.offerLast(new Node(tmpx, tmpy, now.k));
                        visit[now.k][tmpx][tmpy] = visit[now.k][now.x][now.y] + 1;
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            if (visit[i][n - 1][m - 1] != Integer.MAX_VALUE) {
                result = Math.min(result, visit[i][n - 1][m - 1]);
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        br.close();
    }
}
