package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PasteNumber {

    static int cnt;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] graph;
    static int tmpx;
    static int tmpy;

    static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            tmpx = x + dx[i];
            tmpy = y + dy[i];
            if (0 <= tmpx && tmpx < graph.length && 0 <= tmpy && tmpy < graph.length) {
                if (graph[tmpx][tmpy] == 1) {
                    graph[tmpx][tmpy] = 0;
                    cnt++;
                    DFS(tmpx, tmpy);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    cnt = 1;
                    graph[i][j] = 0;
                    DFS(i, j);
                    result.add(cnt);
                }
            }
        }
        Collections.sort(result);

        sb.append(result.size()).append('\n');
        for (Integer integer : result) {
            sb.append(integer).append('\n');
        }
        System.out.println(sb);
    }
}
