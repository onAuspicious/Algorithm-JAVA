package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessBoardRetouch {

    public int howManyRetouch(String[][] board, int i, int j, String s) {
        String now = s;
        int cnt = 0;

        for (int k = 0; k < 8; k++) {
            for (int l = 0; l < 8; l++) {
                if (!now.equals(board[i + k][j + l])) {
                    cnt++;
                }
                System.out.println("now: " + now + " board : " + board[i+k][j+l] + " k, l" + k + " " + l);
                if (now.equals("B")) {
                    now = "W";
                } else {
                    now = "B";
                }
            }
            if (now.equals("B")) {
                now = "W";
            } else {
                now = "B";
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        ChessBoardRetouch main = new ChessBoardRetouch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] l1 = br.readLine().split(" ");
        int N = Integer.parseInt(l1[0]);
        int M = Integer.parseInt(l1[1]);
        int result = 1000000;
        String[][] board = new String[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            board[i] = split;
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                result = Math.min(result, main.howManyRetouch(board, i, j, "W"));
                result = Math.min(result, main.howManyRetouch(board, i, j, "B"));
            }
        }

        System.out.println(result);
    }
}
