package problems;

public class GPS {

    static int result = 100000;

    public void dfs(int now, int level, int changeCnt, int[] gps_log, int[][] graph) {
        if (level == gps_log.length) {
            if (now == gps_log[gps_log.length - 1]) {
                result = Math.min(result, changeCnt);
            }
        } else {
            for (int i = 0; i < graph.length; i++) {
                if (graph[now][i] == 1) {
                    if (i == gps_log[level]) {
                        dfs(i, level + 1, changeCnt, gps_log, graph);
                    } else {
                        dfs(i, level + 1, changeCnt + 1, gps_log, graph);
                    }
                }
            }
        }
    }

    public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int[][] graph = new int[n + 1][n + 1];

        // init graph
        for (int[] edge : edge_list) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        dfs(gps_log[0], 1, 0, gps_log, graph);

        return result;
    }
}
