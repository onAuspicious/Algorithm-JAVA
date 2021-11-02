package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class GoodByeFineDust {

    static int r, c, t;
    static int cleanerRowUp, cleanerRowDown;
    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayDeque<int[]> diffusions = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);
        board = new int[r][c];
        boolean flag = true; // -1 find -> false

        for (int i = 0; i < r; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(line[j]);
                if (board[i][j] == -1) {
                    if (flag) {
                        flag = false;
                        cleanerRowUp = i;
                    } else cleanerRowDown = i;
                }
            }
        }

        while (t-- > 0) {
            cleanerActivate();
        }

        int dust = 2;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dust += board[i][j];
            }
        }
        System.out.println(dust);
    }

    // 1번의 확산 만큼만 일어납니다.
    private static void cleanerActivate() {
        // 1. dust move
        int tmpx, tmpy;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 0 || board[i][j] < 5) {
                    continue;
                }

                int cnt = 0;
                for (int k = 0; k < 4; k++) {
                    tmpx = i + dx[k];
                    tmpy = j + dy[k];
                    if (0 <= tmpx && tmpx < r && 0 <= tmpy && tmpy < c && board[tmpx][tmpy] != -1) {
                        cnt++;
                        diffusions.offerLast(new int[]{tmpx, tmpy, board[i][j] / 5});
                    }
                }
                board[i][j] -= cnt * (board[i][j] / 5);
            }
        }
        while (!diffusions.isEmpty()) {
            int[] dust = diffusions.removeFirst();
            board[dust[0]][dust[1]] += dust[2];
        }

        // 2. cleaner activate
        int before = 0;
        int next = 0;
        int beforeDown = 0;
        int nextDown = 0;
        for (int i = 1; i < c; i++) {
            next = board[cleanerRowUp][i];
            board[cleanerRowUp][i] = before;
            before = next;
            nextDown = board[cleanerRowDown][i];
            board[cleanerRowDown][i] = beforeDown;
            beforeDown = nextDown;
        }
        for (int i = cleanerRowUp - 1; i >= 0; i--) {
            next = board[i][c - 1];
            board[i][c - 1] = before;
            before = next;
        }
        for (int i = cleanerRowDown + 1; i < r; i++) {
            nextDown = board[i][c - 1];
            board[i][c - 1] = beforeDown;
            beforeDown = nextDown;
        }
        for (int i = c - 2; i >= 0; i--) {
            next = board[0][i];
            board[0][i] = before;
            before = next;
            nextDown = board[r - 1][i];
            board[r - 1][i] = beforeDown;
            beforeDown = nextDown;
        }
        for (int i = 1; i < cleanerRowUp; i++) {
            next = board[i][0];
            board[i][0] = before;
            before = next;
        }
        for (int i = r - 2; i > cleanerRowDown; i--) {
            nextDown = board[i][0];
            board[i][0] = beforeDown;
            beforeDown = nextDown;
        }
    }
}
