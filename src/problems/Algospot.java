package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Algospot {

    static int n, m; // n : ㄱㅏ로, m : 세로
    static int[][] graph;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Node implements Comparable<Node>{
        int r;
        int c;
        int crush;

        @Override
        public int compareTo(Node o) {
            return this.crush - o.crush;
        }

        public Node(int r, int c, int crush) {
            this.r = r;
            this.c = c;
            this.crush = crush;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[m][n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.offer(new Node(0, 0, 0));
        int[][] visit = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(visit[i], Integer.MAX_VALUE);
        }
        visit[0][0] = 0;

        while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            if (now.crush > visit[now.r][now.c]) continue;
            for (int i = 0; i < 4; i++) {
                int tmpx = now.r + dx[i];
                int tmpy = now.c + dy[i];
                int tmpCrush = now.crush;
                if (0 <= tmpx && tmpx < m && 0 <= tmpy && tmpy < n) {
                    if (graph[tmpx][tmpy] == 1) {
                        tmpCrush++;
                    }
                    if (tmpCrush < visit[tmpx][tmpy]) {
                        visit[tmpx][tmpy] = tmpCrush;
                        nodes.offer(new Node(tmpx, tmpy, tmpCrush));
                    }
                }
            }
        }

        System.out.println(visit[m-1][n-1]);
    }
}
