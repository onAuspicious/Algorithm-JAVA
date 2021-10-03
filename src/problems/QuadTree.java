package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuadTree {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        quadTree(0, 0, n);
        System.out.println(sb);
    }

    private static void quadTree(int x, int y, int len) {
        int cnt = 0;
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                cnt += board[i][j];
            }
        }

        if (cnt == 0) {
            sb.append(0);
        } else if (cnt == len * len) {
            sb.append(1);
        } else {
            int size = len / 2;
            sb.append("(");
            quadTree(x, y, size);
            quadTree(x, y + size, size);
            quadTree(x + size, y, size);
            quadTree(x + size, y + size, size);
            sb.append(")");
        }
    }
}
