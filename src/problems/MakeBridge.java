package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MakeBridge {

    static int n;
    static int[][] graph;
    static int distance = Integer.MAX_VALUE;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Node {
        int x;
        int y;
        int move;

        public Node(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        int regions = regionNumbering(); // 지역 개수
        boolean[] visitedRegion = new boolean[regions]; // regions 는 실제보다 1 크다

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] != 0 && !visitedRegion[graph[i][j]]) {
                    visitedRegion[graph[i][j]] = true;
                    findShortest(graph[i][j], i, j);
                }
            }
        }

        System.out.println(distance);
    }

    // region Number 지역으로부터 가장 짧은 거리를 가지는 region 을 return
    public static void findShortest(int regionNumber, int regionX, int regionY) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];

        dq.offerLast(new Node(regionX, regionY, 0));
        visit[regionX][regionY] = true;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            if (now.move >= distance) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && !visit[tmpx][tmpy]) {
                    if (graph[tmpx][tmpy] == regionNumber) {
                        dq.offerLast(new Node(tmpx, tmpy, 0));
                        visit[tmpx][tmpy] = true;
                    } else if (graph[tmpx][tmpy] == 0) {
                        dq.offerLast(new Node(tmpx, tmpy, now.move + 1));
                        visit[tmpx][tmpy] = true;
                    } else {
                        distance = Math.min(now.move, distance);
                    }
                }
            }
        }
    }

    public static int regionNumbering() {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[n][n];
        int cur = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && graph[i][j] != 0) {
                    dq.offerLast(new Node(i, j, 0));
                    graph[i][j] = cur;
                    visit[i][j] = true;

                    while (!dq.isEmpty()) {
                        Node now = dq.removeFirst();
                        for (int k = 0; k < 4; k++) {
                            int tmpx = now.x + dx[k];
                            int tmpy = now.y + dy[k];
                            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && !visit[tmpx][tmpy] && graph[tmpx][tmpy] != 0) {
                                graph[tmpx][tmpy] = cur;
                                visit[tmpx][tmpy] = true;
                                dq.offerLast(new Node(tmpx, tmpy, 0));
                            }
                        }
                    }
                    cur++;
                }
            }
        }
        return cur;
    }
}
