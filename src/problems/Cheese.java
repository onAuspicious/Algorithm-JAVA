package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Cheese {

    static int n, m;
    static int[][] graph;
    static boolean[][] outrage;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][m];
        outrage = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 1) BFS to make real out range
        checkNothing(0, 0);

        // 2) C -> Nothing
        int time = 0;
        ArrayDeque<Node> removed = new ArrayDeque<>();
        while (!checkAllNodeTrue()) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 1 && countAround(i, j) >= 2) {
                        removed.offerLast(new Node(i, j));
                    }
                }
            }
            while (!removed.isEmpty()) {
                Node node = removed.removeFirst();
                checkNothing(node.x, node.y);
                graph[node.x][node.y] = 0;
            }
            time++;
        }
        System.out.println(time);
    }

    public static void checkNothing(int x, int y) {
        if (outrage[x][y]) {
            return;
        }
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offerLast(new Node(x, y));
        outrage[x][y] = true;

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && graph[tmpx][tmpy] == 0 && !outrage[tmpx][tmpy]) {
                    outrage[tmpx][tmpy] = true;
                    dq.offerLast(new Node(tmpx, tmpy));
                }
            }
        }
    }

    public static boolean checkAllNodeTrue() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!outrage[i][j]) return false;
            }
        }
        return true;
    }

    public static int countAround(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            if (outrage[x + dx[i]][y + dy[i]]) {
                cnt++;
            }
        }
        return cnt;
    }
}
