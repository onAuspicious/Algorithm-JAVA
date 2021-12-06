package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class BabyShark {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int[][] board;
    static int sharkSize = 2, sharkEat = 0;

    static class Shark implements Comparable<Shark>{
        int x;
        int y;

        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        int start_x = 0, start_y = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(input[j]);
                if (cur == 9) {
                    start_x = i;
                    start_y = j;
                    continue;
                }
                board[i][j] = cur;
            }
        }

        System.out.println(eat(start_x, start_y));
    }

    public static int eat(int x, int y) {
        boolean[][] visit = new boolean[n][n];
        ArrayDeque<Shark> dq = new ArrayDeque<>();
        PriorityQueue<Shark> eatable = new PriorityQueue<>();
        int time = 0;

        dq.offerLast(new Shark(x, y));

        while (!dq.isEmpty() && eatable.isEmpty()) {
            time++;
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                Shark now = dq.removeFirst();
                for (int j = 0; j < 4; j++) {
                    int tmpx = now.x + dx[j];
                    int tmpy = now.y + dy[j];
                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && !visit[tmpx][tmpy] && board[tmpx][tmpy] <= sharkSize) {
                        Shark next = new Shark(tmpx, tmpy);
                        if (board[tmpx][tmpy] < sharkSize && board[tmpx][tmpy] != 0) {
                            eatable.offer(next);
                        }
                        dq.offerLast(next);
                        visit[tmpx][tmpy] = true;
                    }
                }
            }
        }

        if (eatable.isEmpty()) return 0;

        Shark eatPoint = eatable.poll();
        board[eatPoint.x][eatPoint.y] = 0;
        sharkEat++;
        if (sharkEat == sharkSize) {
            sharkEat = 0;
            sharkSize++;
        }

        return eat(eatPoint.x, eatPoint.y) + time;
    }
}
