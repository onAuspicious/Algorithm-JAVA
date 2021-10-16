package problems;

public class RotationMatrix {
    static int[] result;
    static int[][] board;

    public int[] solution(int rows, int columns, int[][] queries) {
        // init board
        board = new int[rows][columns];
        int now = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = now;
                now++;
            }
        }

        // find result
        result = new int[queries.length];
        for (int i = 0; i < queries.length; i++){
            int[] q = queries[i];
            result[i] = move(q[0] - 1, q[1] - 1, q[2] - 1, q[3] - 1);
            for (int[] b : board) {
                for (int a : b) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

        return result;
    }

    // 회전하는 애들 중 가장 작은 수 반환, 시계방향
    static int move(int ux, int uy, int dx, int dy) {
        int before = board[ux][uy];
        int min = before; // maximum value
        // 위 -> 오른쪽으로
        for (int i = uy + 1; i <= dy; i++) {
            int tmp = board[ux][i];
            min = Math.min(min, tmp);
            board[ux][i] = before;
            before = tmp;
        }
        // 오른 -> 아래쪽으로
        for (int i = ux + 1; i<= dx; i++) {
            int tmp = board[i][dy];
            min = Math.min(min, tmp);
            board[i][dy] = before;
            before = tmp;
        }
        // 오른아래 -> 왼아래
        for (int i = dy - 1; i >= uy; i--) {
            int tmp = board[dx][i];
            min = Math.min(min, tmp);
            board[dx][i] = before;
            before = tmp;
        }
        // 왼아래 -> 왼 위
        for (int i = dx - 1; i >= ux; i--) {
            int tmp = board[i][uy];
            min = Math.min(min, tmp);
            board[i][uy] = before;
            before = tmp;
        }
        return min;
    }
}
