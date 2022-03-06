package problems;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PostDelivery {

    static int n, m;
    static ArrayList<Node>[] graph;

    static class Node implements Comparable<Node>{
        int dest;
        int dist;

        public Node(int dest, int dist) {
            this.dest = dest;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int dist = Integer.parseInt(input[2]);
            graph[a].add(new Node(b, dist));
            graph[b].add(new Node(a, dist));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        int[] distances = new int[n + 1];
        Arrays.fill(distances, 100000000);
        distances[1] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (distances[now.dest] < now.dist) {
                continue;
            }
            distances[now.dest] = now.dist;

            for (Node node : graph[now.dest]) {
                if (distances[node.dest] > distances[now.dest] + node.dist) {
                    pq.offer(new Node(node.dest, distances[now.dest] + node.dist));
                }
            }
        }

        System.out.println(distances[n]);
    }
}
