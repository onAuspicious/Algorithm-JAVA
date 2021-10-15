package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class StartTaxi {

    static int n, m, fuel; // n = 크기, m = 태울 승객 수, fuel 초기 연료
    static int[][] graph; // board
    static boolean[][] memo;
    static ArrayDeque<Taxi> dq = new ArrayDeque<>();
    static HashMap<Integer, int[]> passengers = new HashMap<>();
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, -1, 1, 0};

    static class Taxi {
        int x;
        int y;
        int fuel;
        int move;
        int passenger;

        public Taxi(int x, int y, int fuel, int move, int passenger) {
            this.x = x;
            this.y = y;
            this.fuel = fuel;
            this.move = move;
            this.passenger = passenger;
        }

        @Override
        public String toString() {
            return "Taxi{" +
                    "x=" + x +
                    ", y=" + y +
                    ", fuel=" + fuel +
                    ", move=" + move +
                    ", passenger=" + passenger +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]); m = Integer.parseInt(split[1]); fuel = Integer.parseInt(split[2]);
        graph = new int[n][n];
        memo = new boolean[n][n];
        int gx = 0, gy = 0; // 승객이 탑승할 시 변경

        int result = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 택시 위치
        String[] t = br.readLine().split(" ");
        int startX = Integer.parseInt(t[0]) - 1;
        int startY = Integer.parseInt(t[1]) - 1;
        Taxi taxi = new Taxi(startX, startY, fuel, 0, 0);


        // 승객들 좌표 설정
        for (int i = 2; i < m + 2; i++) {
            String[] input = br.readLine().split(" ");
            graph[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = i;
            passengers.put(i, new int[]{Integer.parseInt(input[2]) - 1, Integer.parseInt(input[3]) - 1});
        }


        boolean state;
        if (graph[startX][startY] > 1) {
            taxi.passenger = graph[startX][startY];
            int[] p = passengers.get(graph[startX][startY]);
            gx = p[0]; gy = p[1];
            state = true;
            graph[startX][startY] = 0;
        } else {
            state = false;
        }
        dq.offerLast(taxi);

        while (!dq.isEmpty()) {
            Taxi now = dq.removeFirst();
            // 승객을 태워야합니다.
            if (!state) {
                for (int i = 0; i < 4; i++) {
                    int tmpx = now.x + dx[i];
                    int tmpy = now.y + dy[i];
                    int tmpMove = now.move + 1;
                    int tmpFuel = now.fuel - 1;

                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && graph[tmpx][tmpy] != 1 && !memo[tmpx][tmpy]) {
                        if (graph[tmpx][tmpy] > 0 && tmpFuel > 0) {
                            state = true; // 사람 태운 상태
                            dq.clear();
                            int[] goal = passengers.get(graph[tmpx][tmpy]);
                            gx = goal[0];
                            gy = goal[1];
                            dq.offerLast(new Taxi(tmpx, tmpy, tmpFuel, 0, graph[tmpx][tmpy]));
                            graph[tmpx][tmpy] = 0;
                            memo = new boolean[n][n];
                            memo[tmpx][tmpy] = true;
                            break;
                        }
                        if (tmpFuel > 0) {
                            memo[tmpx][tmpy] = true;
                            dq.offerLast(new Taxi(tmpx, tmpy, tmpFuel, tmpMove, now.passenger));
                        }
                    }
                }
            } else { // 승객을 태웠을때
                for (int i = 0; i < 4; i++) {
                    int tmpx = now.x + dx[i];
                    int tmpy = now.y + dy[i];
                    int tmpMove = now.move + 1;
                    int tmpFuel = now.fuel - 1;

                    if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && graph[tmpx][tmpy] != 1 && !memo[tmpx][tmpy]) {
                        if (gx == tmpx && gy == tmpy) {
                            dq.clear();
                            tmpFuel = tmpMove * 2 + tmpFuel;
                            passengers.remove(now.passenger);
                            if (graph[tmpx][tmpy] > 1) { // 내린 곳이 곧 출발지일때
                                int[] goal = passengers.get(graph[tmpx][tmpy]);
                                gx = goal[0];
                                gy = goal[1];
                                dq.offerLast(new Taxi(tmpx, tmpy, tmpFuel, 0, graph[tmpx][tmpy]));
                                graph[tmpx][tmpy] = 0;
                            } else {
                                state = false;
                                dq.offerLast(new Taxi(tmpx, tmpy, tmpFuel, 0, graph[tmpx][tmpy]));
                            }
                            result = tmpFuel;
                            memo = new boolean[n][n];
                            memo[tmpx][tmpy] = true;
                            break;
                        } else {
                            if (tmpFuel > 0) {
                                memo[tmpx][tmpy] = true;
                                dq.offerLast(new Taxi(tmpx, tmpy, tmpFuel, tmpMove, now.passenger));
                            }
                        }
                    }
                }
            }
        }

        // 결과 출력부
        if (passengers.isEmpty()) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
