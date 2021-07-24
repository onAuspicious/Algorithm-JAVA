package programmers;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Optional;

public class KakaoFriendsColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int[][] memo = new int[m][n];
        int[] dx = new int[]{-1, 0, 1, 0}; int[] dy = new int[]{0, 1, 0, -1};
        int tmpX = 0; int tmpY = 0;
        ArrayDeque<int[]> deque = new ArrayDeque<>();
        int result = 0;
        int maximum = 0;
        HashMap<Integer, Integer> maximumSize = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0 & picture[i][j] != 0) {
                    deque.add(new int[]{i, j});
                    result += 1;
                    memo[i][j] = result;

                    while (!deque.isEmpty()) {
                        int[] now = deque.pop();

                        for (int k = 0; k < 4; k++) {
                            tmpX = now[0] + dx[k];
                            tmpY = now[1] + dy[k];

                            if (0 <= tmpX & tmpX < m & 0 <= tmpY & tmpY < n) {
                                if (picture[tmpX][tmpY] == picture[i][j] & memo[tmpX][tmpY] == 0) {
                                    deque.add(new int[]{tmpX, tmpY});
                                    memo[tmpX][tmpY] = result;
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] == 0) {
                    continue;
                }
                if (!maximumSize.containsKey(memo[i][j])) {
                    maximumSize.put(memo[i][j], 1);
                } else {
                    maximumSize.put(memo[i][j], maximumSize.get(memo[i][j]) + 1);
                }
                maximum = Math.max(maximum, maximumSize.get(memo[i][j]));
            }
        }
        return new int[]{result, maximum};
    }

    public static void main(String[] args) {
        KakaoFriendsColoringBook kakaoFriendsColoringBook = new KakaoFriendsColoringBook();
        int[][] picture = new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] solution = kakaoFriendsColoringBook.solution(6, 4, picture);
        System.out.println(solution[0] + " " + solution[1]);
    }
}
