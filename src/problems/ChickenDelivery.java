package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class ChickenDelivery {

    static int n, m; // n : n * n 인 도시 사이즈, m : 없어져야할 치킨 가게수
    static int result = Integer.MAX_VALUE;
    static ArrayList<Chicken> chickens = new ArrayList<>();
    static ArrayDeque<Chicken> choice = new ArrayDeque<>();
    static ArrayDeque<int[]> dq = new ArrayDeque<>();
    static HashSet<Integer> set = new HashSet<>();
    static boolean[] check;
    static int[][] graph;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};


    static class Chicken {
        int x;
        int y;
        public Chicken (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(line[j]);
                if (now == 2){ chickens.add(new Chicken(i, j));}
                else graph[i][j] = now;
            }
        }
        check = new boolean[chickens.size()];
        DFS(0);
        System.out.println(result);
    }

    public static void DFS(int level) {
        if (level == chickens.size()) {
            if (choice.size() == m) {
                // BFS Start
                for (Chicken chicken : choice) {
                    graph[chicken.x][chicken.y] = 2;
                }
                result = Math.min(result, BFS());
                for (Chicken chicken : choice) {
                    graph[chicken.x][chicken.y] = 0;
                }
            }
            return;
        }
        choice.offerLast(chickens.get(level));
        DFS(level + 1);
        choice.removeLast();
        DFS(level + 1);
    }

    public static int BFS() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {
                    set.add(i * 10 + j);
                    dq.offerLast(new int[]{i, j, 0});
                    boolean breakState = true;
                    while (breakState && !dq.isEmpty()) {
                        int[] now = dq.removeFirst();
                        for (int k = 0; k < 4; k++) {
                            int tmpx = now[0] + dx[k];
                            int tmpy = now[1] + dy[k];
                            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && !set.contains(tmpx * 10 + tmpy)) {
                                if (graph[tmpx][tmpy] == 2) {
                                    cnt += now[2] + 1;
                                    breakState = false;
                                    break;
                                } else {
                                    set.add(tmpx * 10 + tmpy);
                                    dq.offerLast(new int[]{tmpx, tmpy, now[2] + 1});
                                }
                            }
                        }
                    }
                    set.clear();
                    dq.clear();
                }
            }
        }
        return cnt;
    }
}
