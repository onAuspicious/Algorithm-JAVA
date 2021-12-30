package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Fire {

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
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int col = Integer.parseInt(input[0]);
            int row = Integer.parseInt(input[1]);
            int[][] board = new int[row][col];
            int startX = 0, startY = 0;
            ArrayDeque<Node> fires = new ArrayDeque<>();

            for (int j = 0; j < row; j++) {
                String line = br.readLine();
                for (int k = 0; k < col; k++) {
                    if (line.charAt(k) == '#') {
                        board[j][k] = 1;
                    } else if (line.charAt(k) == '*') {
                        board[j][k] = 2;
                        fires.offerLast(new Node(j, k));
                    } else if (line.charAt(k) == '@') {
                        startX = j;
                        startY = k;
                        board[j][k] = 3; // player
                    }
                }
            }

            int move;
            if ((move = checkEscape(row, col, startX, startY, board, fires)) > 0) {
                sb.append(move).append('\n');
            } else {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }

        System.out.println(sb);
    }

    public static int checkEscape(int row, int col, int start_x, int start_y, int[][] board, ArrayDeque<Node> fires) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(start_x, start_y));
        int move = 0;

        while (!dq.isEmpty()) {
            move++;

            // fire move
            int fireSize = fires.size();
            for (int i = 0; i < fireSize; i++) {
                Node now = fires.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int tmpx = now.x + dx[j];
                    int tmpy = now.y + dy[j];
                    if (0 <= tmpx && tmpx < row && 0 <= tmpy && tmpy < col && (board[tmpx][tmpy] == 0 || board[tmpx][tmpy] == 3)) {
                        board[tmpx][tmpy] = 2;
                        fires.offerLast(new Node(tmpx, tmpy));
                    }
                }
            }

            // sangeun move
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                Node now = dq.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int tmpx = now.x + dx[j];
                    int tmpy = now.y + dy[j];
                    if (rangeCheck(row, col, tmpx, tmpy)) {
                        if (board[tmpx][tmpy] == 0) {
                            dq.offerLast(new Node(tmpx, tmpy));
                            board[tmpx][tmpy] = 3;
                        }
                    } else {
                        return move;
                    }
                }
            }
        }

        return 0;
    }

    public static boolean rangeCheck(int row, int col, int x, int y) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }
}
