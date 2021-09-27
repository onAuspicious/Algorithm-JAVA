package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Labo {

    static int[][] original;
    static int[][] copy;
    static int n;
    static int m;
    static int result = Integer.MIN_VALUE;
    static ArrayList<Point> saveTwo = new ArrayList<>();
    static ArrayDeque<Point> dq = new ArrayDeque<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void DFS(int level) {
        if (level == 3) {
            result = Math.max(result, BFS());
            dq.clear();
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (original[i][j] == 0) {
                        original[i][j] = 1;
                        DFS(level + 1);
                        original[i][j] = 0;
                    }
                }
            }
        }
    }

    static int BFS() {
        copy();

        while (!dq.isEmpty()) {
            Point pop = dq.removeFirst();
            for (int i = 0; i < 4; i++) {
                int tmpx = pop.x + dx[i];
                int tmpy = pop.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && copy[tmpx][tmpy] == 0) {
                    copy[tmpx][tmpy] = 2;
                    dq.add(new Point(tmpx, tmpy));
                }
            }
        }
        return count0();
    }

    static void copy() {
        copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = original[i][j];
            }
        }

        for (Point p : saveTwo) {
            dq.offer(p);
        }
    }

    static int count0() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        original = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int val = Integer.parseInt(line[j]);
                if (val == 2) saveTwo.add(new Point(i, j));
                original[i][j] = Integer.parseInt(line[j]);
            }
        }

        DFS(0);

        System.out.println(result);
    }
}
