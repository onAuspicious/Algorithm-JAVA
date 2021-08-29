package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MazeSearch {

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] maze = new int[N][M];
        int length;
        int tmpx;
        int tmpy;
        int result = 1;
        ArrayDeque<int[]> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        deque.add(new int[]{0, 0});
        maze[0][0] = 0;

        while (!deque.isEmpty()) {
            length = deque.size();
            if (maze[N - 1][M - 1] == 0) {
                System.out.println(result);
                break;
            }
            for (int i = 0; i < length; i++) {
                int[] pop = deque.pop();

                for (int j = 0; j < 4; j++) {
                    tmpx = pop[0] + dx[j];
                    tmpy = pop[1] + dy[j];
                    if (0 <= tmpx && tmpx < N && 0 <= tmpy && tmpy < M && maze[tmpx][tmpy] == 1) {
                        deque.add(new int[]{tmpx, tmpy});
                        maze[tmpx][tmpy] = 0;
                    }
                }
            }
            result++;
        }
    }
}
