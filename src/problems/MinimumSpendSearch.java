package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumSpendSearch {

    static ArrayList<int[]>[] graph;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        int[] distances = new int[n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0])].add(new int[]{Integer.parseInt(input[1]), Integer.parseInt(input[2])});
        }
        String[] input = br.readLine().split(" ");

        int start = Integer.parseInt(input[0]); // start
        int goal = Integer.parseInt(input[1]); // goal

        pq.offer(new int[]{start, 0});
        distances[start] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (distances[now[0]] < now[1]) {
                continue;
            }
            for (int[] node : graph[now[0]]) {
                if (distances[node[0]] > node[1] + now[1]) {
                    distances[node[0]] = now[1] + node[1];
                    pq.offer(new int[]{node[0], now[1] + node[1]});
                }
            }
        }
        System.out.println(distances[goal]);
    }
}