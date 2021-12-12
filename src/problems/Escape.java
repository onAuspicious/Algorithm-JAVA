package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Escape {

    static int r, c;
    static char[][] board;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int end_r, end_c;

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
        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        board = new char[r][c];
        ArrayDeque<Node> water = new ArrayDeque<>();
        ArrayDeque<Node> hedgehog = new ArrayDeque<>();

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == 'S') {
                    hedgehog.offer(new Node(i, j));
                } else if (line.charAt(j) == '*') {
                    water.offer(new Node(i, j));
                } else if (line.charAt(j) == 'D') {
                    board[i][j] = line.charAt(j);
                    end_r = i; end_c = j;
                }
                board[i][j] = line.charAt(j);

            }
        }

        boolean result = false;
        int cnt = 0;

        while (!hedgehog.isEmpty()) {
            cnt++;
            oneMinute(water, hedgehog);
            for (char[] chars : board) {
                for (char c : chars) {
                    System.out.print(c + " ");
                }
                System.out.println();
            }
            System.out.println();
            if (board[end_r][end_c] == 'S') {
                result = true;
                break;
            }
        }

        System.out.println(result ? cnt : "KAKTUS");
    }

    public static void oneMinute(ArrayDeque<Node> water, ArrayDeque<Node> hedgehog) {
        int wSize = water.size();
        int hSize = hedgehog.size();

        // 미리 바다를 늘려주기
        for (int i = 0; i < wSize; i++) {
            Node now = water.removeFirst();
            for (int j = 0; j < 4; j++) {
                int tmpx = now.x + dx[j];
                int tmpy = now.y + dy[j];
                if (0 <= tmpx && tmpx < r && 0 <= tmpy && tmpy < c && (board[tmpx][tmpy] == '.' || board[tmpx][tmpy] == 'S')) {
                    board[tmpx][tmpy] = '*';
                    water.offerLast(new Node(tmpx, tmpy));
                }
            }
        }

        // 고슴도치 이동
        for (int i = 0; i < hSize; i++) {
            Node now = hedgehog.removeFirst();
            for (int j = 0; j < 4; j++) {
                int tmpx = now.x + dx[j];
                int tmpy = now.y + dy[j];
                if (0 <= tmpx && tmpx < r && 0 <= tmpy && tmpy < c && (board[tmpx][tmpy] == '.' || board[tmpx][tmpy] == 'D')) {
                    board[tmpx][tmpy] = 'S';
                    hedgehog.offerLast(new Node(tmpx, tmpy));
                }
            }
        }
    }
}
