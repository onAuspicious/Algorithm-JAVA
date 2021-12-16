package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Cheese_2636 {

    static int n, m;
    static int[][] board;
    static boolean[][] air;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayDeque<Node> airDeque = new ArrayDeque<>();

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
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        board = new int[n][m];
        air = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        // air 배열의 초기 구역 입력
        airDeque.offerLast(new Node(0, 0));
        fillAir();

        int time = 0;
        int lastCheese = 0;
        int cheese;

        // 치즈가 0개가 될 때 까지 순차적으로 진행합니다.
        // 1. lastCheese 에 현재 board에 있는 모든 치즈의 개수를 저장합니다.
        // 2. cheeseMelt() 를 호출해 치즈를 녹입니다.
        // 3. fillAir() 를 호출해 공기를 채웁니다.
        // 4. time++ 로 지나온 시간을 추가합니다.
        while ((cheese = getCheeseCnt()) > 0) {
            lastCheese = cheese;
            cheeseMelt();
            fillAir();
            time++;
        }

        sb.append(time).append('\n').append(lastCheese);
        System.out.println(sb);
        br.close();
    }

    // 치즈가 남아있는지 확인합니다. while 문의 종료 조건을 담당합니다.
    // 마지막으로 남은 치즈를 카운팅 하기 위해 int형을 반환합니다.
    public static int getCheeseCnt() {
        int cheese = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) cheese++;
            }
        }
        return cheese;
    }

    // 모든 노드들을 개별 탐색하며 치즈를 녹입니다.
    // isMelted() 함수로 치즈가 녹을 수 있는지 판단하고 녹게되면 airDeque()를 호출해 공기로 변환합니다.
    public static void cheeseMelt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1 && isMelted(i, j)) {
                    board[i][j] = 0;
                    airDeque.offerLast(new Node(i, j));
                }
            }
        }
    }

    // 공기를 채우는 함수, airDeque에 있는 값으로 BFS를 돌려 공기를 채워간다.
    public static void fillAir() {
        while (!airDeque.isEmpty()) {
            Node now = airDeque.removeFirst();
            air[now.x][now.y] = true;

            for (int i = 0; i < 4; i++) {
                int tmpx = now.x + dx[i];
                int tmpy = now.y + dy[i];
                if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < m && !air[tmpx][tmpy] && board[tmpx][tmpy] == 0) {
                    air[tmpx][tmpy] = true;
                    airDeque.offerLast(new Node(tmpx, tmpy));
                }
            }
        }
    }

    // 선택된 위치의 치즈가 녹는 치즈이면 true, 녹지 않는 치즈이면 false를 반환
    public static boolean isMelted(int x, int y) {
        boolean melt = false;
        for (int i = 0; i < 4; i++) {
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            if (air[tmpx][tmpy]) {
                melt = true;
                break;
            }
        }
        return melt;
    }
}
