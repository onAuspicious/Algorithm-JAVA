package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightLimit {

    static int n, m;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int goal;
        int dist;

        public Node(int goal, int dist) {
            this.goal = goal;
            this.dist = dist;
        }


        @Override
        public int compareTo(Node o) {
            return o.dist - this.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        String[] input = br.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int result = Integer.MAX_VALUE;
        boolean[] visit = new boolean[n + 1];
        visit[start] = true;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, Integer.MAX_VALUE));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            result = Math.min(result, now.dist);
            visit[now.goal] = true;

            if (now.goal == end) break;

            for (Node next : graph[now.goal]) {
                if (!visit[next.goal]) {
                    pq.offer(next);
                }
            }
        }
        System.out.println(result);
    }
}