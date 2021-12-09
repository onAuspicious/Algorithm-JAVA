package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Iceberg {

    static int n, m;
    static int[][] board;
    static int[][] melt;
    static boolean[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }
        br.close();

        while (true) {
            int cnt = 0;
            melt = new int[n][m];
            visit = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visit[i][j] && board[i][j] > 0) {
                        visit[i][j] = true;
                        melting(i, j);
                        cnt++;
                    }
                }
            }

            if (cnt == 0) {
                result = 0;
                break;
            } else if (cnt > 1) break;
            result++;
        }

        System.out.println(result);
    }

    public static void melting(int x, int y) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(x, y));

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (!visit[tmpx][tmpy] && board[tmpx][tmpy] > 0) {
                    dq.offerLast(new Node(tmpx, tmpy));
                    visit[tmpx][tmpy] = true;
                }
                if (board[tmpx][tmpy] <= 0) {
                    sea++;
                }
            }
            melt[now.x][now.y] = sea;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] -= melt[i][j];
            }
        }
    }
}
