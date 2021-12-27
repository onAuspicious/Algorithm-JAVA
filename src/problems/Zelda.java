package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Zelda {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n;
        int cur = 1;
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            sb.append("Problem ").append(cur++).append(": ").append(solution(n, br)).append('\n');
        }
        System.out.println(sb);
        br.close();
    }

    public static int solution(int n, BufferedReader br) throws IOException {
        int[][] graph = new int[n][n];
        int[][] visit = new int[n][n];

        // graph, visit array init
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                visit[i][j] = Integer.MAX_VALUE;
            }
        }
        visit[0][0] = graph[0][0];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, visit[0][0]));

        // dijkstra algorithm
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (visit[now.x][now.y] < now.price) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && visit[tmpx][tmpy] > now.price + graph[tmpx][tmpy]) {
                    pq.offer(new Node(tmpx, tmpy, now.price + graph[tmpx][tmpy]));
                    visit[tmpx][tmpy] = now.price + graph[tmpx][tmpy];
                }
            }
        }

        return visit[n - 1][n - 1];
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int price;

        public Node(int x, int y, int price) {
            this.x = x;
            this.y = y;
            this.price = price;
        }

        @Override
        public int compareTo(Node o) {
            return this.price - o.price;
        }
    }
}
