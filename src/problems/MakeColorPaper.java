package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeColorPaper {

    static int[][] board;
    static int green, white;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        // INIT BOARD
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        cut(0, 0, n);
        sb.append(white).append('\n').append(green);
        System.out.println(sb);
    }

    private static void cut(int x, int y, int len) {
        int cnt = 0;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y+len; j++) {
                cnt += board[i][j];
            }
        }

        if (cnt == len * len) {
            green++;
        } else if (cnt == 0) {
            white++;
        } else {
            int size = len / 2;
            cut(x, y, size);
            cut(x, y + size, size);
            cut(x + size, y, size);
            cut(x + size, y + size, size);
        }
    }
}
