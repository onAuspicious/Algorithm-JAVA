package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class DistanceCheck {
    public int[] solution(String[][] places) {
        int[] result = new int[]{1 ,1, 1, 1, 1};
        int now = 0;

        for (String[] place : places) {
            boolean state = true;
            for (int j = 0; j < 5; j++) {
                for (int i = 0; i < 5; i++) {
                    if (place[j].charAt(i) == 'P' & state) {
                        Deque<int[]> deque = new ArrayDeque<>();
                        deque.add(new int[]{j, i});
                        if (checkTwoPoint(place, deque)) {
                            result[now] = 1;
                        } else {
                            result[now] = 0;
                            state = false;
                        }
                    }
                }
            }
            now += 1;
        }
        return result;
    }

    public boolean checkTwoPoint(String[] place, Deque<int[]> deque) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][] memo = new boolean[5][5];

        memo[deque.getFirst()[0]][deque.getFirst()[1]] = true;
        int count = 0;

        while (!deque.isEmpty() & count < 2) {

            int size = deque.size();
            for (int j = 0; j < size; j++) {
                int[] now = deque.poll();

                for (int i = 0; i < 4; i++) {
                    int tmpX = now[0] + dx[i];
                    int tmpY = now[1] + dy[i];
                    int[] next = {tmpX, tmpY};

                    if (0 <= tmpX & tmpX <= 4 & 0 <= tmpY & tmpY <= 4) {
                        if (place[tmpX].charAt(tmpY) == 'O' & !memo[tmpX][tmpY]) {
                            memo[tmpX][tmpY] = true;
                            deque.add(next);
                        } else if (place[tmpX].charAt(tmpY) == 'P' & !memo[tmpX][tmpY]) {
                            return false;
                        }
                    }
                }
            }
            count += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        DistanceCheck distanceCheck = new DistanceCheck();
        int[] solution = distanceCheck.solution(places);
    }
}
