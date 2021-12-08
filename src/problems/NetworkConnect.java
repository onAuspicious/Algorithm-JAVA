package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkConnect {

    static ArrayList<Node>[] network;

    static class Node implements Comparable<Node>{
        int goal;
        int price;

        public Node(int goal, int price) {
            this.goal = goal;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return price - o.price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = 0;
        network = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            network[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
            network[a].add(new Node(b, p));
            network[b].add(new Node(a, p));
        }
        br.close();

        PriorityQueue<Node> linePriorityQueue = new PriorityQueue<>();
        boolean[] visit = new boolean[n + 1];
        linePriorityQueue.offer(new Node(1, 0));

        while (!linePriorityQueue.isEmpty()) {
            Node now = linePriorityQueue.poll();

            if (visit[now.goal]) continue;
            result += now.price;
            visit[now.goal] = true;

            for (Node node : network[now.goal]) {
                if (!visit[node.goal]) {
                    linePriorityQueue.offer(node);
                }
            }
        }
        System.out.println(result);
    }
}
