package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class CityDividePlan {

    static int n, m;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int vil;
        int price;

        public Node(int vil, int price) {
            this.vil = vil;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new ArrayList[n + 1];

        // graph init
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
            graph[a].add(new Node(b, p));
            graph[b].add(new Node(a, p));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        int result = 0;
        int max = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visit[now.vil]) continue;
            result += now.price;
            max = Math.max(max, now.price);
            visit[now.vil] = true;

            for (Node node : graph[now.vil]) {
                if (!visit[node.vil]) {
                    pq.offer(node);

                }
            }
        }
        result -= max;
        System.out.println(result);
    }
}