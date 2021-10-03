package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PaperCount {

    static int[][] board;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        solution(0, 0, n);
        for (int i = 0; i < 3; i++) {
            sb.append(result[i]).append('\n');
        }
        System.out.println(sb);
    }

    public static void solution(int x, int y, int len) {
        boolean same = true;
        int standard = board[x][y];
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (board[i][j] != standard) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        if (same) {
            result[standard + 1]++;
        } else {
            int size = len / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solution(x + i * size, y + j * size, size);
                }
            }
        }
    }
}
