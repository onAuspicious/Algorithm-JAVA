package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {

    public int result = 0;

    public boolean check(int[][] board, int row, int col, int n) {
        for (int i = 1; i < col + 1; i++) {
            if (0 <= row - i) {
                if (board[row - i][col - i] == 1) {
                    return false;
                }
            }
            if (row + i < n) {
                if (board[row + i][col - i] == 1) {
                    return false;
                }
            }
            if (board[row][col - i] == 1) {
                return false;
            }
        }
        return true;
    }

    public void solution(int n, int col, int[][] board) {
        if (col == n) {
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (check(board, i, col, n)) {
                board[i][col] = 1;
                solution(n, col + 1, board);
                board[i][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NQueen main = new NQueen();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] board = new int[input][input];
        main.solution(input, 0, board);
        System.out.println(main.result);
    }
}
