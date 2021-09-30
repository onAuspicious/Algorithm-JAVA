package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotCleaner {

    static int[][] board;
    static int pointX; // 청소기 x
    static int pointY; // 청소기 y
    static int direction; // 청소기 방향
    static int n;
    static int m;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        String[] point = br.readLine().split(" ");
        pointX = Integer.parseInt(point[0]);
        pointY = Integer.parseInt(point[1]);
        direction = Integer.parseInt(point[2]);
        n = Integer.parseInt(split[0]);
        m = Integer.parseInt(split[1]);
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            cleaning();
            boolean state = true;
            for (int i = 0; i < 4; i++) {
                if (moving()) {
                    state = false;
                    break;
                }
            }
            if (state) {
                int tmpx = pointX + dx[(direction + 2) % 4];
                int tmpy = pointY + dy[(direction + 2) % 4];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && board[tmpx][tmpy] != 1) {
                    pointX = tmpx;
                    pointY = tmpy;
                } else {
                    break;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    static void cleaning() {
        board[pointX][pointY] = 2;
    }

    static boolean moving() {
        // a
        int tmpx = pointX + dx[(direction + 3) % 4];
        int tmpy = pointY + dy[(direction + 3) % 4];
        direction = (direction + 3) % 4;
        if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && board[tmpx][tmpy] == 0) {
            pointX = tmpx;
            pointY = tmpy;
            return true;
        }
        return false;
    }
}
