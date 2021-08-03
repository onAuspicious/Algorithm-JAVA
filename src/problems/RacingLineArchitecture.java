package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class RacingLineArchitecture {
    public int solution(int[][] board) {
        int size = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int[][] memo = new int[board.length][board.length]; //세로 상태
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                memo[i][j] = 10000000;
            }
        }
        int[] next;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0, 1}); // x, y, money, state: 0 세로, 1 가로
        deque.add(new int[]{0, 0, 0, 0});

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();

            for (int i = 0; i < 4; i++) {
                int tmpX = poll[0] + dx[i];
                int tmpY = poll[1] + dy[i];

                if (0 <= tmpX & tmpX < size & 0 <= tmpY & tmpY < size) {
                    if (board[tmpX][tmpY] != 0) {
                        continue;
                    }
                    if (poll[3] == i % 2) {
                        next = new int[]{tmpX, tmpY, poll[2] + 100, poll[3]};
                    } else {
                        next = new int[]{tmpX, tmpY, poll[2] + 600, i % 2};
                    }
                    if (next[2] <= memo[next[0]][next[1]]) {
                        memo[next[0]][next[1]] = next[2];
                        deque.add(next);
                    }
                }
            }
        }
        return memo[size - 1][size - 1];
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};

        RacingLineArchitecture racingLineArchitecture = new RacingLineArchitecture();
        System.out.println(racingLineArchitecture.solution(board));
    }
}
