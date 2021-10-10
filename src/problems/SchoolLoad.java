package problems;

public class SchoolLoad {

    static int d = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] graph = new int[n][m];
        boolean[][] dp = new boolean[n][m];

        graph[0][0] = 1;

        for (int[] puddle : puddles) {
            dp[puddle[1] - 1][puddle[0] - 1] = true;
        }

        for (int i = 1; i < n; i++) {
            if (dp[i][0]) break;
            graph[i][0] = graph[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            if (dp[0][i]) break;
            graph[0][i] = graph[0][i - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j]) continue;
                graph[i][j] = (graph[i - 1][j] + graph[i][j - 1]) % d;
            }
        }

        return graph[n - 1][m - 1];
    }
}
