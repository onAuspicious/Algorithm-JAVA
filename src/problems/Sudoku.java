package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sudoku {

    static int[][] board = new int[9][9];
    static ArrayList<int[]> emptySpots = new ArrayList<>();

    public boolean sudoku(int count) {
        if (count == emptySpots.size()) {
            return true;
        } else {
            int[] position = emptySpots.get(count);
            for (int i = 1; i < 10; i++) {
                if (check(position[0], position[1], i, board)) {
                    board[position[0]][position[1]] = i;
                    if (sudoku(count + 1)) {
                        return true;
                    } else {
                        board[position[0]][position[1]] = 0;
                    }
                }
            }
        }
        return false;
    }

    public boolean check(int row, int col, int now, int[][] board) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == now && i != col) {
                return false;
            }
            if (board[i][col] == now && i != row) {
                return false;
            }
            if (row / 3 * 3 + i / 3 != row && col / 3 * 3 + i % 3 != col) {
                if (board[row / 3 * 3 + i / 3][col / 3 * 3 + i % 3] == now) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Sudoku main = new Sudoku();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] saveInput = new String[9][9];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            String[] input = br.readLine().split(" ");
            saveInput[i] = input;
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(saveInput[i][j]);
                if (board[i][j] == 0) {
                    emptySpots.add(new int[]{i, j});
                }
            }
        }

        main.sudoku(0);

        for (int[] line : board) {
            for (int i : line) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
