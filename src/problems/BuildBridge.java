package problems;

import java.util.PriorityQueue;

public class BuildBridge {

    static class Node implements Comparable<Node>{
        int goal;
        int distance;

        public Node(int goal, int price) {
            this.goal = goal;
            this.distance = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public int solution(int[] x, int[] y) {
        int size = x.length;
        int result = 0;
        boolean[] visit = new boolean[size];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (!visit[now.goal]) {
                visit[now.goal] = true;
                result = Math.max(result, now.distance);
            }

            for (int i = 0; i < size; i++) {
                if (!visit[i]) {
                    int distance = getDistance(x[now.goal], y[now.goal], x[i], y[i]);
                    pq.offer(new Node(i, distance));
                }
            }
        }

        return result;
    }

    public int getDistance(int x1, int y1, int x2, int y2) {
        double result = Math.sqrt(((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
        return (int)Math.ceil(result);
    }

    public static void main(String[] args) {
        BuildBridge line2 = new BuildBridge();
        int distance = line2.getDistance(0, 0, 1, 1);
        System.out.println(distance);
    }
}
