package problems;

import java.util.*;

public class TreeDivide2 {

    static int[][] graph;
    static int result = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        graph = new int[n + 1][n + 1];

        // init graph
        for (int i = 0; i < n-1; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        // remove and BFS
        for (int i = 0; i < n - 1; i++) {
            int x = wires[i][0];
            int y = wires[i][1];
            graph[x][y] = 0;
            graph[y][x] = 0;

            check.clear();
            BFS(n);

            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        return result;
    }

    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static HashSet<Integer> check = new HashSet<>();

    static void BFS(int n) {
        int val = 0;
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            dq.offerLast(i);
            check.add(i);
            while (!dq.isEmpty()) {
                int now = dq.removeFirst();
                for (int j = 1; j <= n; j++) {
                    if (graph[now][j] == 1 && !check.contains(j)) {
                        dq.offerLast(j);
                        check.add(j);
                        cnt++;
                    }
                }
            }
            val = Math.abs(val - cnt);
        }
        result = Math.min(result, val);
    }
}
