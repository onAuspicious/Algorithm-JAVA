package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Fire2 {

    static int n, m;
    static ArrayDeque<Node> fires = new ArrayDeque<>();
    static ArrayDeque<Node> dq = new ArrayDeque<>();
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
        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == '#') {
                    board[i][j] = 1;
                } else if (line.charAt(j) == 'J') {
                    dq.offerLast(new Node(i, j));
                    board[i][j] = 3;
                } else if (line.charAt(j) == 'F') {
                    fires.offerLast(new Node(i, j));
                    board[i][j] = 2;
                }
            }
        }

        int time = checkEscape(board);
        System.out.println(time > 0 ? time : "IMPOSSIBLE");
    }

    public static int checkEscape(int[][] board) {
        int time = 0;

        while (!dq.isEmpty()) {
            time++;

            // fire move
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                Node fire = fires.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int tmpx = fire.x + dx[j];
                    int tmpy = fire.y + dy[j];
                    if (checkMove(board, tmpx, tmpy) && (board[tmpx][tmpy] == 0 || board[tmpx][tmpy] == 3)) {
                        board[tmpx][tmpy] = 2;
                        fires.offerLast(new Node(tmpx, tmpy));
                    }
                }
            }

            int dqSize = dq.size();
            for (int i = 0; i < dqSize; i++) {
                Node now = dq.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int tmpx = now.x + dx[j];
                    int tmpy = now.y + dy[j];
                    if (!checkMove(board, tmpx, tmpy)) {
                        return time;
                    } else if (board[tmpx][tmpy] == 0) {
                        board[tmpx][tmpy] = 2;
                        dq.offerLast(new Node(tmpx, tmpy));
                    }
                }
            }
        }

        return -1;
    }

    public static boolean checkMove(int[][] board, int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
