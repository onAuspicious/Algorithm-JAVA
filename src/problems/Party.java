package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Party {

    static int n, m, x;
    static ArrayList<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);

        // graph init
        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // graph input
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0])].add(new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }

        int result = 0;
        for (int i = 1; i < n + 1; i++) {
            result = Math.max(result, dijkstra(i, x) + dijkstra(x, i));
        }

        System.out.println(result);
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[] distances = new int[n + 1];

        // init distances, pq
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (distances[now[0]] < now[1]) {
                continue;
            }
            for (int i = 0; i < graph[now[0]].size(); i++) {
                int[] next = graph[now[0]].get(i);
                if (next[1] + now[1] < distances[next[0]]) {
                    distances[next[0]] = next[1] + now[1];
                    pq.offer(new int[]{next[0], next[1] + now[1]});
                }
            }
        }
        return distances[end];
    }
}
