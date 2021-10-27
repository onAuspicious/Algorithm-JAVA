package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class PeopleMove {
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n, l, r;
    static int[][] graph;
    static int[][] visited;
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int tmpx;
    static int tmpy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]); l = Integer.parseInt(input[1]); r = Integer.parseInt(input[2]);
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = 0;

        while (true) {
            visited = new int[n][n];
            map.clear();
            int connected = 0;
            int cur = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == 0) {
                        connected += searchUnion(i, j, cur);
                        cur++;
                    }
                }
            }

            if (connected == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = map.get(visited[i][j]);
                }
            }

            result++;
        }
        System.out.println(result);
    }

    public static int searchUnion(int x, int y, int num) {
        int sum = graph[x][y];
        visited[x][y] = num;
        int connected = 0;

        dq.offerLast(new int[]{x, y});
        while (!dq.isEmpty()) {
            int[] pop = dq.removeFirst();
            for (int i = 0; i < 4; i++) {
                tmpx = pop[0] + dx[i];
                tmpy = pop[1] + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && visited[tmpx][tmpy] == 0) {
                    int val = Math.abs(graph[tmpx][tmpy] - graph[pop[0]][pop[1]]);
                    if (l <= val && val <= r) {
                        visited[tmpx][tmpy] = num;
                        dq.offerLast(new int[]{tmpx, tmpy});
                        sum += graph[tmpx][tmpy];
                        connected++;
                    }
                }
            }
        }
        map.put(num, sum / (connected + 1));
        return connected;
    }
}