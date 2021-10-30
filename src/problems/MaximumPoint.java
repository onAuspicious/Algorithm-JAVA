package problems;

public class MaximumPoint {

    static int result = 0;

    public int solution(int[][] board) {
        DFS(0, 0, 0, board);
        return result;
    }

    //  x = 행, y = 열
    public void DFS(int x, int y, int point, int[][] board) {
        if (x == 4 && y == 4) {
            if (board[x][y] == 0) {
                result = Math.max(result, Math.max(point, -1 * point));
            } else {
                result = Math.max(result, point + board[x][y]);
            }
            return;
        }
        // 0인 경우, 아닌 경우
        if (board[x][y] == 0) {
            if (y + 1 < 5) {
                DFS(x, y + 1, point * -1, board);
                DFS(x, y + 1, point, board);
            }
            if (x + 1 < 5) {
                DFS(x + 1, y, point * -1, board);
                DFS(x + 1, y, point, board);
            }
        } else {
            if (y + 1 < 5) {
                DFS(x, y + 1, point + board[x][y], board);
            }
            if (x + 1 < 5) {
                DFS(x + 1, y, point + board[x][y], board);
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = new int[][]{{1, -7, -2, 1, -1},{2, 3, 0, -1, -2},{1, -1, 6, -1, -2},{-1, 1, -2, 0, 4},{-10, 5, -3, -1, 1}};
        MaximumPoint maximumPoint = new MaximumPoint();
        int solution = maximumPoint.solution(board);
        System.out.println(solution);
    }
}
