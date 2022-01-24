package problems;

public class ScaffoldingDisappear {

    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};
    int r, c;
    int[] result = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};


    public int solution(int[][] board, int[] aloc, int[] bloc) {
        r = board.length;
        c = board[0].length;

        DFS(board, aloc[0], aloc[1], bloc[0], bloc[1], 0, 1);

        if (result[0] == Integer.MAX_VALUE) {
            return result[1];
        } else if (result[1] == Integer.MAX_VALUE) {
            return result[0];
        } else {
            System.out.println(result[0] + " " + result[1]);
            return Math.max(result[0], result[1]);
        }
    }

    public void DFS(int[][] board, int nowX, int nowY, int nextX, int nextY, int move, int player) {
        if (board[nowX][nowY] == 0) {
            setResult(move, player);
            return;
        }
        int check = movePointCheck(board, nowX, nowY, nextX, nextY);
        if (check == 1) {
            setResult(move, player);
            return;
        } else if (check == 2) {
            board[nowX][nowY] = 0;
            DFS(board, nextX, nextY, nextX, nextY, move + 1, player * -1);
            board[nowX][nowY] = 1;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int tmpx = nowX + dx[i];
            int tmpy = nowY + dy[i];
            if (0 <= tmpx && tmpx < r && 0 <= tmpy && tmpy < c && board[tmpx][tmpy] == 1 && !(tmpx == nextX && tmpy == nextY)) {
                board[nowX][nowY] = 0;
                DFS(board,nextX, nextY, tmpx, tmpy, move + 1, player * -1);
                board[nowX][nowY] = 1;
            }
        }
    }

    public void setResult(int move, int player) {
        if (player == 1) {
            result[1] = Math.min(result[1], move);
        } else {
            result[0] = Math.min(result[0], move);
        }
    }

    // 상 하 좌 우 체크
    public int movePointCheck(int[][] board, int x, int y, int rx, int ry) {
        boolean state = false;
        for (int i = 0; i < 4; i++) {
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            if (rx == tmpx && ry == tmpy) {
                state = true;
                continue;
            }

            // 다음 위치로 갈 수 있는 경우
            if (0 <= tmpx && tmpx < r && 0 <= tmpy && tmpy < c && board[tmpx][tmpy] == 1) {
                return 0;
            }
        }

        // 갈 수 있는곳이 한 곳 밖에 없는데 이미 누군가 위에 올라가 있는 상황
        if (state) return 2;
        // 더이상 갈 곳이 없는 상황
        return 1;
    }

    public static void main(String[] args) {
        ScaffoldingDisappear scaffoldingDisappear = new ScaffoldingDisappear();
        int solution = scaffoldingDisappear.solution(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 0}, new int[]{1, 2});
        System.out.println(solution);
    }
}
