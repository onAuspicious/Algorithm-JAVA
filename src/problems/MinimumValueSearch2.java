package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumValueSearch2 {

    static int n, m;
    static int start, end;
    static int[] memo;
    static int max = 1000000003;
    static int[] route;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        @Override
        public int compare(int[] a, int[] b) {
            return a[1] - b[1];
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        ArrayList<int[]>[] graph = new ArrayList[n+1];
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        int a, b, distance;
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            a = Integer.parseInt(input[0]);
            b = Integer.parseInt(input[1]);
            distance = Integer.parseInt(input[2]);
            graph[a].add(new int[]{b, distance});
        }

        String[] input = br.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        memo = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        pq.offer(new int[]{start, 0});
        memo[start] = 0;

        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (memo[poll[0]] < poll[1]) {
                continue;
            }
            if (end == poll[0]) break;
            for (int i = 0; i < graph[poll[0]].size(); i++) {
                int next = graph[poll[0]].get(i)[0];
                int nextDistance = poll[1] + graph[poll[0]].get(i)[1];

                if (nextDistance < memo[next]) {
                    memo[next] = nextDistance;
                    pq.offer(new int[]{next, nextDistance});
                    route[next] = poll[0];
                }
            }
        }

        sb.append(memo[end]).append('\n');
        ArrayList<Integer> result = new ArrayList<>();
        int cur = end;
        while (cur != start) {
            result.add(cur);
            cur = route[cur];
        }
        result.add(cur);
        sb.append(result.size()).append('\n');
        for (int i = result.size() - 1; i >= 0; i--) {
            sb.append(result.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}