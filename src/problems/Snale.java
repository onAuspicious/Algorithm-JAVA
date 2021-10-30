package problems;

public class Snale {
    static int left, right, up, down;
    static int num = 2;

    public int[] solution(int n, int jump) {

        int[][] board = new int[n][n];
        board[0][0] = 1;
        jump--;
        int move = 0;
        while (num <= n*n) {
            left = 0; right = n-1; up = 0; down = n-1;
            while (left <= right && up <= down) {
                for (int j = left; j <= right; j++) {
                    if (move < jump && board[up][j] == 0) {
                        move++;
                        continue;
                    }
                    if (board[up][j] == 0 && move == jump) {
                        board[up][j] = num++;
                        move = 0;
                    }
                }
                up++;

                for (int j = up; j <= down; j++) {
                    if (move < jump && board[j][right] == 0) {
                        move++;
                        continue;
                    }
                    if (board[j][right] == 0 && move == jump) {
                        board[j][right] = num++;
                        move = 0;
                    }
                }
                right--;

                for (int j = right; j >= left; j--) {
                    if (move < jump && board[down][j] == 0) {
                        move++;
                        continue;
                    }
                    if (board[down][j] == 0 && move == jump) {
                        board[down][j] = num++;
                        move = 0;
                    }
                }
                down--;

                for (int j = down; j >= up; j--) {
                    if (move < jump && board[j][left] == 0) {
                        move++;
                        continue;
                    }
                    if (board[j][left] == 0 && move == jump) {
                        board[j][left] = num++;
                        move = 0;
                    }
                }
                left++;
            }
        }

        int find = n * n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
                if (board[i][j] == find) return new int[] {i+1, j+1};
            }
            System.out.println();
        }
        System.out.println();
        return new int[] {1, 1};
    }

    public static void main(String[] args) {
        Snale test = new Snale();
        int[] solution = test.solution(5, 3);
        System.out.println(solution[0] + solution[1]);
    }
}
