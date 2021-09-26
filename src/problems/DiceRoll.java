package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiceRoll {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[][] board;
    static int n;
    static int m;
    static int x;
    static int y;
    static int[][] dice = new int[4][3];

    public static void main(String[] args) throws IOException {
        String[] setting = br.readLine().split(" ");
        n = Integer.parseInt(setting[0]);
        m = Integer.parseInt(setting[1]);
        x = Integer.parseInt(setting[2]);
        y = Integer.parseInt(setting[3]);
        int k = Integer.parseInt(setting[4]);
        board = new int[n][m];

        // INIT BOARD
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        String[] test = br.readLine().split(" ");

        for (int i = 0; i < k; i++) {
            if (test[i].equals("1")) {
                //EAST
                if (y + 1 < m) {
                    copy();
                    diceToRight();
                    y++;
                    sb.append(dice[1][1]).append('\n');
                }
            } else if (test[i].equals("2")) {
                //WEST
                if (y - 1 >= 0) {
                    copy();
                    diceToLeft();
                    y--;
                    sb.append(dice[1][1]).append("\n");
                }
            } else if (test[i].equals("3")) {
                //NORTH
                if (x - 1 >= 0) {
                    copy();
                    diceToUp();
                    x--;
                    sb.append(dice[1][1]).append('\n');
                }
            } else {
                //SOUTH
                if (x + 1 < n) {
                    copy();
                    diceToDown();
                    x++;
                    sb.append(dice[1][1]).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    static void diceToLeft() {
        int tmp = dice[1][0];
        dice[1][0] = dice[1][1];
        dice[1][1] = dice[1][2];
        dice[1][2] = dice[3][1];
        dice[3][1] = tmp;
    }

    static void diceToRight() {
        int tmp = dice[1][2];
        dice[1][2] = dice[1][1];
        dice[1][1] = dice[1][0];
        dice[1][0] = dice[3][1];
        dice[3][1] = tmp;
    }

    static void diceToUp() {
        int tmp = dice[0][1];
        for (int i = 0; i < 3; i++) {
            dice[i][1] = dice[i + 1][1];
        }
        dice[3][1] = tmp;
    }

    static void diceToDown() {
        int tmp = dice[3][1];
        for (int i = 3; i > 0; i--) {
            dice[i][1] = dice[i - 1][1];
        }
        dice[0][1] = tmp;
    }

    static void copy() {
        if (board[x][y] == 0) {
            board[x][y] = dice[3][1];
        } else {
            dice[3][1] = board[x][y];
            board[x][y] = 0;
        }
    }
}
