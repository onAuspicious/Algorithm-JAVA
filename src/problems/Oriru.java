package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Oriru {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int min = 0;
        int[][] board = new int[n][3];
        int[][] maxBoard = new int[n][3];
        int[][] minBoard = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < 3; i++) {
            maxBoard[0][i] = board[0][i];
            minBoard[0][i] = board[0][i];
        }

        for (int i = 1; i < n; i++) {
            maxBoard[i][0] = board[i][0] + Math.max(maxBoard[i - 1][0], maxBoard[i - 1][1]);
            maxBoard[i][1] = board[i][1] + Math.max(maxBoard[i - 1][0], Math.max(maxBoard[i - 1][1], maxBoard[i - 1][2]));
            maxBoard[i][2] = board[i][2] + Math.max(maxBoard[i - 1][1], maxBoard[i - 1][2]);
            minBoard[i][0] = board[i][0] + Math.min(minBoard[i - 1][0], minBoard[i - 1][1]);
            minBoard[i][1] = board[i][1] + Math.min(minBoard[i - 1][0], Math.min(minBoard[i - 1][1], minBoard[i - 1][2]));
            minBoard[i][2] = board[i][2] + Math.min(minBoard[i - 1][1], minBoard[i - 1][2]);
        }

        for (int i = 0; i < 3; i++) {
            max = Math.max(maxBoard[n - 1][0], Math.max(maxBoard[n - 1][1], maxBoard[n - 1][2]));
            min = Math.min(minBoard[n - 1][0], Math.min(minBoard[n - 1][1], minBoard[n - 1][2]));
        }
        System.out.println(max + " " + min);
    }
}
