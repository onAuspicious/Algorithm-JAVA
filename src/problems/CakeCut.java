package problems;
import java.util.*;

class CakeCut {
    static char[][] graph;
    static int size;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public int solution(String[] cakes, int[] cut_rows, int[] cut_columns) {
        size = cakes.length;
        graph = new char[size * 2][size * 2];

        for (int i = 0; i < size * 2; i = i + 2) {
            for (int j = 0; j < size; j++) {
                graph[i][j * 2] = cakes[i/2].charAt(j);
            }
        }

        // row line draw
        for (int row : cut_rows) {
            row = row * 2 - 1;
            for (int i = 0; i < size * 2; i++) {
                graph[row][i] = 'x';
            }
        }

        // col line draw
        for (int col : cut_columns) {
            col = col * 2 - 1;
            for (int i = 0; i < size * 2; i++) {
                graph[i][col] = 'x';
            }
        }

        boolean[][] visit = new boolean[size*2][size*2];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        HashSet<Character> flavour = new HashSet<>();
        int result = 0;

        for (int i = 0; i < size * 2; i++) {
            for (int j = 0; j < size * 2; j++) {
                if (!visit[i][j] && graph[i][j] != 'x') {
                    visit[i][j] = true;
                    dq.offerLast(new int[]{i, j});
                    flavour.add(graph[i][j]);
                    while (!dq.isEmpty()) {
                        int[] now = dq.removeFirst();
                        for (int k = 0; k < 4; k++) {
                            int tmpx = now[0] + dx[k];
                            int tmpy = now[1] + dy[k];
                            if (0 <= tmpx && tmpx < size*2 && 0 <= tmpy && tmpy < size*2 && !visit[tmpx][tmpy] && graph[tmpx][tmpy] != 'x') {
                                dq.offerLast(new int[]{tmpx, tmpy});
                                flavour.add(graph[tmpx][tmpy]);
                                visit[tmpx][tmpy] = true;
                            }
                        }
                    }
                    result = Math.max(result, flavour.size() - 1);
                    flavour.clear();
                }
            }
        }
        return result;
    }
}