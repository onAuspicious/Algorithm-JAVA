package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class KnightMove {

    static int[] dx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static int cnt;
    static int length;
    static int x;
    static int y;
    static int tmpx;
    static int tmpy;

    static void solution(boolean[][] board, int I) {
        cnt = 0;
        while (!board[x][y]) {
            length = deque.size();
            for (int i = 0; i < length; i++) {
                int[] pop = deque.pop();
                for (int j = 0; j < 8; j++) {
                    tmpx = pop[0] + dx[j];
                    tmpy = pop[1] + dy[j];
                    if (0 <= tmpx && tmpx < I && 0 <= tmpy && tmpy < I && !board[tmpx][tmpy]) {
                        board[tmpx][tmpy] = true;
                        deque.add(new int[]{tmpx, tmpy});
                    }
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int I;

        for (int i = 0; i < n; i++) {
            I = Integer.parseInt(br.readLine());
            boolean[][] board = new boolean[I][I];
            String[] knight = br.readLine().split(" ");
            String[] goal = br.readLine().split(" ");
            x = Integer.parseInt(goal[0]);
            y = Integer.parseInt(goal[1]);
            board[Integer.parseInt(knight[0])][Integer.parseInt(knight[1])] = true;
            deque.add(new int[]{Integer.parseInt(knight[0]), Integer.parseInt(knight[1])});
            solution(board, I);
            deque.clear();
            sb.append(cnt).append('\n');
        }
        System.out.println(sb);
    }
}
