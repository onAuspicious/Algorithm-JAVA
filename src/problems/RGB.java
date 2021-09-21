package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class RGB {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static int normalBFS(String[][] graph, int n) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        boolean[][] check = new boolean[n][n];

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    //BFS start
                    dq.add(new int[]{i, j});
                    check[i][j] = true;
                    while (!dq.isEmpty()) {
                        int[] pop = dq.pop();
                        for (int k = 0; k < 4; k++) {
                            int tmpx = pop[0] + dx[k];
                            int tmpy = pop[1] + dy[k];
                            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n) {
                                if (graph[tmpx][tmpy].equals(graph[pop[0]][pop[1]]) && !check[tmpx][tmpy]) {
                                    dq.add(new int[]{tmpx, tmpy});
                                    check[tmpx][tmpy] = true;
                                }
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] graph = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                graph[i][j] = input[j];
            }
        }
        sb.append(normalBFS(graph, n)).append(" ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j].equals("R")) {
                    graph[i][j] = "G";
                }
            }
        }
        sb.append(normalBFS(graph, n));
        System.out.println(sb);
    }
}
