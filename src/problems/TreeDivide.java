package problems;

import java.util.ArrayDeque;
import java.util.HashSet;

public class TreeDivide {

    static int[] combination = new int[2];
    static int[][] graph;
    static int size;
    static int[] result = new int[2];
    static int n;
    static HashSet<Integer> checkDuple = new HashSet<>();
    static ArrayDeque<Integer> dq = new ArrayDeque<>();

    static int[] solution(int n, int[][] edges) {
        graph = new int[n][n];
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }
        DFS(0, -1, n - 1, edges);
        return result;
    }

    public static void main(String[] args) {
        n = 9;
        size = n / 3;
        int[][] edges = new int[][]{{0, 2}, {2, 1}, {2, 4}, {3, 5}, {5, 4}, {5, 7}, {7, 6}, {6, 8}};
        int[] solution = solution(n, edges);
        System.out.println(solution[0] + " " + solution[1]);
    }

    public static void DFS(int level, int now, int n, int[][] edges) {
        if (level == 2) {
            // 2개 간선 삭제
            for (int i = 0; i < 2; i++) {
                int[] removed = edges[combination[i]];
                graph[removed[0]][removed[1]] = 0;
                graph[removed[1]][removed[0]] = 0;
            }
            // BFS
            checkDuple.clear();
            if (BFS()) {
                result[0] = combination[0];
                result[1] = combination[1];
            }
            // 2개 간선 회복
            for (int i = 0; i < 2; i++) {
                int[] removed = edges[combination[i]];
                graph[removed[0]][removed[1]] = 1;
                graph[removed[1]][removed[0]] = 1;
            }
        } else {
            for (int i = now + 1; i < n; i++) {
                combination[level] = i;
                DFS(level + 1, i, n, edges);
            }
        }
    }

    public static boolean BFS() {
        for (int i = 0; i < n; i++) {
            if (!checkDuple.contains(i)) {
                checkDuple.add(i);
                dq.add(i);
                int cnt = 1;
                while (!dq.isEmpty()) {
                    Integer now = dq.pollFirst();
                    for (int j = 0; j < n; j++) {
                        if (graph[now][j] == 1 && !checkDuple.contains(j)) {
                            dq.add(j);
                            checkDuple.add(j);
                            cnt++;
                        }
                    }
                }
                if (cnt != size) {
                    return false;
                }
            }
        }
        return true;
    }
}
