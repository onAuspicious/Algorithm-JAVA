package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Tomato_7576 {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static boolean result(int[][] graph) {
        for (int[] line : graph) {
            for (int i : line) {
                if (i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[0]);
        int[][] graph = new int[n][m];
        int result = -1;
        int length;
        int tmpx;
        int tmpy;
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] == 1) {
                    deque.add(new int[]{i, j});
                }
            }
        }

        while (!deque.isEmpty()) {
            length = deque.size();
            for (int i = 0; i < length; i++) {
                int[] pop = deque.pop();
                for (int j = 0; j < 4; j++) {
                    tmpx = pop[0] + dx[j];
                    tmpy = pop[1] + dy[j];
                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && graph[tmpx][tmpy] == 0) {
                        graph[tmpx][tmpy] = 1;
                        deque.add(new int[]{tmpx, tmpy});
                    }
                }
            }
            result++;
        }

        if (result(graph)) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
