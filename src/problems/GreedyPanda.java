package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GreedyPanda {

    static int[][] board;
    static int[][] visit;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int result = 0;
        board = new int[n][n];
        visit = new int[n][n];

        // 1) 방문한 구역을 담은 visit 배열 -1로 초기화
        // 이유: 0으로 초기화 되어있을 경우 이미 방문한 곳으로 처리될 수 있기 때문
        for (int i = 0; i < n; i++) {
            Arrays.fill(visit[i], -1);
        }

        // board 초기화
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 모든 구역을 탐색해서 가장 긴 거리를 이동할 수 있는 경우를 result 에 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int move = getMoveCount(i, j);
                result = Math.max(result, move);
            }
        }

        System.out.println(result);
        br.close();
    }

    public static int getMoveCount(int x, int y) {
        // 1) 이미 방문한 구역 : 해당 위치로부터 판다가 갈 수 있는 구역의 수를 담고 있을 경우 반환
        if (visit[x][y] > -1) {
            return visit[x][y];
        }

        // 2) 방문하지 않은 구역 : 해당 위치로부터 판다가 갈 수 있는 구역을 모두 탐색해 가장 큰 값을 구하여 반환
        int maxMove = 0;
        for (int i = 0; i < 4; i++) {
            int tmpx = x + dx[i];
            int tmpy = y + dy[i];
            if (0 <= tmpx && tmpx < n && 0 <= tmpy && tmpy < n && board[tmpx][tmpy] > board[x][y]) {
                maxMove = Math.max(maxMove, getMoveCount(tmpx, tmpy));
            }
        }

        // 3) 반환 시에 visit[x][y] 에 값을 저장해 재방문시 이미 방문한 구역 코드에서 반환할 수 있게 처리
        return visit[x][y] = maxMove + 1;
    }
}
