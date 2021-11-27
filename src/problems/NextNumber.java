package problems;

import java.util.*;

public class NextNumber {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            if (distance == o.distance) {
                if (y == o.y) {
                    return x - o.x;
                } else {
                    return y - o.y;
                }
            } else {
                return o.distance - distance;
            }
        }
    }

    public int[] solution(int n, int k) {
        int[][] board = new int[n][n];
        board[0][0] = 1;
        ArrayList<Node> list = new ArrayList<>();
        list.add(new Node(0, 0, 0));

        for (int i = 2; i <= k; i++) {
            ArrayDeque<Node> dq = new ArrayDeque<>();
            for (Node node : list) {
                dq.offerLast(node);
            }
            Node point = checkCurrent(board, n, dq);
            board[point.x][point.y] = i;
            list.add(new Node(point.x, point.y, 0));
        }

        int[] result = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == k) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }

    public Node checkCurrent(int[][] board, int n, ArrayDeque<Node> deque) {
        boolean[][] visit = new boolean[n][n];
        PriorityQueue<Node> nodes = new PriorityQueue<>();

        while (!deque.isEmpty()) {
            Node now = deque.removeFirst();
            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && board[tmpx][tmpy] == 0 && !visit[tmpx][tmpy]) {
                    visit[tmpx][tmpy] = true;
                    Node node = new Node(tmpx, tmpy, now.distance + 1);
                    deque.offerLast(node);
                    nodes.offer(node);
                }
            }
        }

        return nodes.poll();
    }

    public static void main(String[] args) {
        NextNumber line3 = new NextNumber();
        int[] solution = line3.solution(1, 1);
        System.out.println(solution[0] + " " + solution[1]);
    }
}
