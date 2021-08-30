package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Tomato_7569 {

    static int[][][] tomato;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    static boolean check(int[][][] tomato) {
        for (int[][] i : tomato) {
            for (int[] j : i) {
                for (int k : j) {
                    if (k == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int h = Integer.parseInt(input[2]);
        tomato = new int[h][n][m];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = Integer.parseInt(line[k]);
                    if (tomato[i][j][k] == 1) {
                        deque.add(new int[]{i, j, k});
                    }
                }
            }
        }
        int cnt = -1;
        int length;
        int tmpx;
        int tmpy;
        int tmph;

        while (!deque.isEmpty()) {
            length = deque.size();
            for (int i = 0; i < length; i++) {
                int[] pop = deque.removeFirst();
                for (int j = 0; j < 4; j++) {
                    tmpx = pop[1] + dx[j];
                    tmpy = pop[2] + dy[j];
                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && tomato[pop[0]][tmpx][tmpy] == 0) {
                        tomato[pop[0]][tmpx][tmpy] = 1;
                        deque.add(new int[]{pop[0], tmpx, tmpy});
                    }
                }
                tmph = pop[0] - 1;
                if (0 <= tmph && tomato[tmph][pop[1]][pop[2]] == 0) {
                    tomato[tmph][pop[1]][pop[2]] = 1;
                    deque.add(new int[]{tmph, pop[1], pop[2]});
                }
                tmph = pop[0] + 1;
                if (tmph < h && tomato[tmph][pop[1]][pop[2]] == 0) {
                    tomato[tmph][pop[1]][pop[2]] = 1;
                    deque.add(new int[]{tmph, pop[1], pop[2]});
                }
            }
            cnt++;
        }
        if (check(tomato)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }
    }
}
