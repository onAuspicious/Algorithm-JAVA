package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MinimumPath {

    static int v;
    static int e;
    static int start;
    static int INF = Integer.MAX_VALUE;
    static int[] distance;
    static ArrayList<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        v = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        start = Integer.parseInt(br.readLine());
        distance = new int[v + 1];
        list = new ArrayList[v + 1];

        for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<>();
        }

        // init graph
        Arrays.fill(distance, INF);
        distance[start] = 0;

        for (int i = 0; i < e; i++) {
            String[] line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int l = Integer.parseInt(line[1]);
            int val = Integer.parseInt(line[2]);
            list[s].add(new Node(l, val));
        }

        dijkstra();

        for (int i = 0; i <= v; i++) {
            if ((distance[i] == INF)) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (distance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) {
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {

        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
