package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HelpPrincess {

    static int n, m, t;
    static int[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int swordTime = Integer.MAX_VALUE;

    static class Player {
        int x;
        int y;

        public Player(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        t = Integer.parseInt(input[2]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(input[j]);
                board[i][j] = val == 2 ? -1 : val;
            }
        }

        int time = getMinimumTime();

        if (time > 1) {
            time = Math.min(swordTime, time);
            if (time > t) {
                System.out.println("Fail");
            } else {
                System.out.println(time);
            }
        } else if (swordTime != Integer.MAX_VALUE) {
            if (swordTime > t) {
                System.out.println("Fail");
            } else {
                System.out.println(swordTime);
            }
        } else {
            System.out.println("Fail");
        }

        br.close();
    }

    public static int getMinimumTime() {
        ArrayDeque<Player> playerDeque = new ArrayDeque<>();
        playerDeque.offerLast(new Player(0, 0));
        board[0][0] = 0;

        while (!playerDeque.isEmpty()) {
            Player playerNow = playerDeque.removeFirst();
            for (int j = 0; j < 4; j++) {
                int tmpx = playerNow.x + dx[j];
                int tmpy = playerNow.y + dy[j];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m) {
                    if (board[tmpx][tmpy] == 0) {
                        board[tmpx][tmpy] = board[playerNow.x][playerNow.y] + 1;
                        playerDeque.offerLast(new Player(tmpx, tmpy));
                    } else if (board[tmpx][tmpy] == -1) {
                        swordTime = board[playerNow.x][playerNow.y] + 1 + Math.abs(tmpx - (n - 1)) + Math.abs(tmpy - (m - 1));
                        board[tmpx][tmpy] = 1;
                    }
                    if (board[tmpx][tmpy] > t) {
                        return -1;
                    }
                }
            }
        }

        return board[n - 1][m - 1];
    }
}
