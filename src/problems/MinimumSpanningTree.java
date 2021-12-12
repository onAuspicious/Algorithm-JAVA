package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinimumSpanningTree {

    static class Node implements Comparable<Node>{
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node node) {
            return this.distance - node.distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        ArrayList<Node>[] graph = new ArrayList[v + 1];

        // init graph
        for (int i = 0; i < v + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        System.out.println(getMST(graph, v));
        br.close();
    }

    public static int getMST(ArrayList<Node>[] graph, int v) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[v + 1];
        int result = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visit[now.vertex]) continue;

            visit[now.vertex] = true;
            result += now.distance;

            for (Node node : graph[now.vertex]) {
                if (!visit[node.vertex]) {
                    pq.offer(node);
                }
            }
        }
        return result;
    }
}
