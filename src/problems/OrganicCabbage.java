package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrganicCabbage {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int worm;
    static int tmpx; static int tmpy;

    static void solution(int M, int N, int K) throws IOException {
        boolean[][] graph = new boolean[N][M];
        worm = 0;
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            graph[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j]) {
                    graph[i][j] = false;
                    worm++;
                    DFS(i, j, M, N, graph);
                }
            }
        }
    }

    static void DFS(int x, int y, int M, int N, boolean[][] graph) {
        for (int i = 0; i < 4; i++) {
            tmpx = x + dx[i];
            tmpy = y + dy[i];
            if (0 <= tmpx && tmpx < N && 0 <= tmpy && tmpy < M) {
                if (graph[tmpx][tmpy]) {
                    graph[tmpx][tmpy] = false;
                    DFS(tmpx, tmpy, M, N, graph);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            sb.append(worm).append('\n');
        }
        System.out.println(sb);
    }
}
