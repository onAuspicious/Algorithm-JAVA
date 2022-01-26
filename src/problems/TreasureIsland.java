package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TreasureIsland {

    static int n, m;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visit;

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
        visit = new boolean[n][m];
        int result = 0;

        String[] board = new String[n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'L') {
                    result = Math.max(result, findDistance(i, j, board));
                }
            }
        }

        System.out.println(result);
    }

    public static int findDistance(int x, int y, String[] board) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(x, y));
        for (int i = 0; i < n; i++) Arrays.fill(visit[i], false);
        visit[x][y] = true;
        int dist = 0;
        int size;

        while (!dq.isEmpty()) {
            size = dq.size();

            for (int i = 0; i < size; i++) {
                Node now = dq.removeFirst();

                for (int j = 0; j < 4; j++) {
                    int tmpx = now.x + dx[j];
                    int tmpy = now.y + dy[j];
                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && board[tmpx].charAt(tmpy) == 'L' && !visit[tmpx][tmpy]) {
                        visit[tmpx][tmpy] = true;
                        dq.offerLast(new Node(tmpx, tmpy));
                    }
                }
            }
            dist++;
        }

        return dist - 1;
    }
}
