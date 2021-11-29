package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        int[][] board = new int[v][v];

        for (int i = 0; i < v; i++) {
            Arrays.fill(board[i], 100000);
            board[i][i] = 0;
        }

        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            board[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = Integer.parseInt(input[2]);
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                for (int k = 0; k < v; k++) {
                    board[j][k] = Math.min(board[j][k], board[j][i] + board[i][k]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            for (int j = i + 1; j < v; j++) {
                result = Math.min(result, board[i][j] + board[j][i]);
            }
        }

        if (result >= 100000) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
