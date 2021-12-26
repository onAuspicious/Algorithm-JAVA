package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MonkeyWannaBeHorse {

    static int w, h;
    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] hx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        w = Integer.parseInt(input[0]);
        h = Integer.parseInt(input[1]);
        board = new int[h][w];

        for (int i = 0; i < h; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        int result = bfs(0, 0, k);

        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
        br.close();
    }

    public static int bfs(int x, int y, int k) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(x, y, k, 0));
        boolean[][][] visit = new boolean[k + 1][h][w];
        int result = Integer.MAX_VALUE;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();

            if (now.x == h - 1 && now.y == w - 1) return now.move;

            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < h && 0 <= tmpy && tmpy < w && board[tmpx][tmpy] == 0 && !visit[now.k][tmpx][tmpy]) {
                    dq.offerLast(new Node(tmpx, tmpy, now.k, now.move + 1));
                    visit[now.k][tmpx][tmpy] = true;
                }
            }

            if (now.k== 0) continue;

            for (int i = 0; i < 8; i++) {
                int tmpx = now.x + hx[i];
                int tmpy = now.y + hy[i];
                if (0 <= tmpx && tmpx < h && 0 <= tmpy && tmpy < w && board[tmpx][tmpy] == 0 && !visit[now.k - 1][tmpx][tmpy]) {
                    dq.offerLast(new Node(tmpx, tmpy, now.k - 1, now.move + 1));
                    visit[now.k-1][tmpx][tmpy] = true;
                }
            }
        }

        return result;
    }

    static class Node {
        int x;
        int y;
        int k;
        int move;

        public Node(int x, int y, int k, int move) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.move = move;
        }
    }
}
