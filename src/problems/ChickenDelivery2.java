package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class ChickenDelivery2 {

    static int n, m;
    static int[][] graph;
    static ArrayList<Point> chickenPoints;
    static ArrayDeque<Point> dq = new ArrayDeque<>();
    static int result = Integer.MAX_VALUE;
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][n];
        chickenPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(line[j]);
                if (now == 2) {
                    chickenPoints.add(new Point(i, j));
                } else {
                    graph[i][j] = now;
                }
            }
        }
        DFS(0);
        System.out.println(result);
    }

    public static void DFS(int level) {
        if (level == chickenPoints.size()) {
            if (dq.size() == m) {
                result = Math.min(result, searchDistance());
            }
        } else {
            dq.offerLast(chickenPoints.get(level));
            DFS(level + 1);
            dq.removeLast();
            DFS(level + 1);
        }
    }

    public static int searchDistance() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    int dist = Integer.MAX_VALUE;
                    for (Point point : dq) {
                        dist = Math.min(dist, Math.abs(point.x - i) + Math.abs(point.y - j));
                    }
                    cnt += dist;
                }
            }
        }
        return cnt;
    }
}
