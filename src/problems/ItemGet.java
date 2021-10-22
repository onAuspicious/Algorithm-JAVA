package problems;

import java.util.ArrayDeque;

public class ItemGet {

    static boolean[][] board = new boolean[103][103];
    static boolean[][] check = new boolean[103][103];
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayDeque<Node> dq = new ArrayDeque<>();
    static class Node {
        int x;
        int y;
        int move;

        public Node (int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int[] point : rectangle) {
            for (int i = point[0] * 2; i <= point[2] *2; i++) {
                for (int j = point[1] * 2; j <= point[3] * 2; j++) {
                    board[i][j] = true;
                }
            }
        }

        for (int[] point : rectangle) {
            for (int i = point[0] * 2 + 1; i < point[2] * 2; i++) {
                for (int j = point[1] * 2 + 1; j < point[3] * 2; j++) {
                    board[i][j] = false;
                }
            }
        }

        dq.offerLast(new Node(characterX * 2, characterY * 2, 0));
        board[characterX * 2][characterY * 2] = false;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];

                if (0 <= tmpx && tmpx < 103 && 0 <= tmpy && tmpy < 103 && board[tmpx][tmpy]) {
                    board[tmpx][tmpy] = false;
                    dq.offerLast(new Node(tmpx, tmpy, now.move + 1));
                    if (tmpx == itemX * 2 && tmpy == itemY * 2) {
                        return (now.move + 1) / 2;
                    }
                }
            }
        }
        return 0;
    }
}
