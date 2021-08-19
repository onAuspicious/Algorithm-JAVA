package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Alphabet {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[] check = new boolean[26];
    static int result = 0;

    static void search(String[] board, int count, int x, int y, int R, int C) {
        result = Math.max(result, count);

        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (0 <= tmpX && tmpX < R && 0 <= tmpY && tmpY < C) {
                if (!check[board[tmpX].charAt(tmpY) - 'A']) {
                    check[board[tmpX].charAt(tmpY) - 'A'] = true;
                    search(board, count + 1, tmpX, tmpY, R, C);
                    check[board[tmpX].charAt(tmpY) - 'A'] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);
        String[] board = new String[R];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            board[i] = line;
        }

        check[board[0].charAt(0) - 'A'] = true;
        search(board, 1, 0, 0, R, C);
        System.out.println(result);
    }
}
