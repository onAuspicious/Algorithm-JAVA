package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RobotCleaner {

    static int n;
    static int m;
    static int cx;
    static int cy;
    static int d;
    static int[][] graph;
    static int[] dx = new int[]{0, 1, 0, -1}; // 북 -> 동 -> 남 -> 서  , 서 -> 북 -> 동 -> 남
    static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String[] cleanerPoint = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        cx = Integer.parseInt(cleanerPoint[0]);
        cy = Integer.parseInt(cleanerPoint[1]);
        d = Integer.parseInt(cleanerPoint[2]);
        graph = new int[n][m];
        int result = 1;

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        graph[cx][cy] = 2;

        while (true) {
            graph[cx][cy] = 2;
            boolean state = true;

            for (int i = 0; i < 4; i++) {
                int tmpx = cx + dx[d%4];
                int tmpy = cy + dy[d%4];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && graph[tmpx][tmpy] == 0) {
                    cx = tmpx;
                    cy = tmpy;
                    graph[cx][cy] = 2;
                    state = false;
                }
                d++;
            }
            if (state) {
                System.out.println("x: " + cx + " y: " + cy + " d: " + d%4);
                continue;
            }
            d++;
            System.out.println("x: " + cx + " y: " + cy + " d: " + d%4);

            if (!check()) {
                break;
            }
        }

        for (int[] ints : graph) {
            for (int anInt : ints) {
                if (anInt == 2) {
                    result++;
                }
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println(result);
    }

    static boolean check() {
        int tmpx; int tmpy;
        for (int i = 0; i < 4; i++) {
            tmpx = cx + dx[i];
            tmpy = cy + dy[i];
            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && graph[tmpx][tmpy] == 0) {
                return true;
            }
        }
        tmpx = cx + dx[(d + 3) % 4];
        tmpy = cy + dy[(d + 3) % 4];
        if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && graph[tmpx][tmpy] == 2) {
            cx = tmpx;
            cy = tmpy;
            return true;
        }
        return false;
    }
}
