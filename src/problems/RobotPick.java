package problems;

import java.util.HashSet;

public class RobotPick {

    HashSet<Integer> pickedRobots = new HashSet<>();
    int result = 0;
    int[][] copy;

    public int solution(int[][] needs, int r) {
        copy = needs;
        pickNumber(0, needs[0].length, r);
        return result;
    }

    // 로봇 부품을 r 개 만큼 선택하는 조합을 생성합니다.
    // 조합이 생성되면 findCanMake() 함수를 호출해줍니다.
    public void pickNumber(int level, int number, int r) {
        if (r == 0) {
            // method start
            int canMake = findCanMake();
            result = Math.max(result, canMake);
            return;
        }

        for (int i = level; i <= number; i++) {
            pickedRobots.add(i);
            pickNumber(i + 1, number, r - 1);
            pickedRobots.remove(i);
        }
    }

    // 생성한 조합들로 만들 수 있는 완제품 개수를 반환해 주는 함수.
    public int findCanMake() {
        int cnt = 0;
        boolean state;
        for (int[] need : copy) {
            state = true;
            for (int i = 0; i < need.length; i++) {
                if (need[i] == 1 && !pickedRobots.contains(i)) {
                    state = false;
                    break;
                }
            }
            if (state) cnt++;
        }
        return cnt;
    }
}
