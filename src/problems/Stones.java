package problems;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Stones {

    PriorityQueue<String> result = new PriorityQueue<>(Comparator.reverseOrder());
    ArrayDeque<Integer> dq = new ArrayDeque<>();

    public String solution(int[] stones, int k) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        int choice;
        if (k > sum) {
            return "-1";
        } else if (k == sum) {
            StringBuilder sb = new StringBuilder();
            int s1 = stones[0];
            int s2 = stones[1];
            if (s1 > s2) {
                while (stones[1] > 0) {
                    sb.append(0);
                    stones[1]--;
                }
            } else {
                while (stones[0] > 0) {
                    sb.append(1);
                    stones[0]--;
                }
            }
            return sb.toString();
        } else {
            if (stones.length == 2) {
                return "-1";
            }
            choice = (sum - k) / (stones.length - 2);
        }
        DFS(0, choice, stones, k);
        return result.isEmpty() ? "-1" : result.poll();
    }

    public void DFS(int level, int choice, int[] stones, int k) {
        if (level == choice) {
            int check = 0;
            for (int stone : stones) {
                if (stone > 0) check++;
            }
            if (check > 1) return;

            StringBuilder sb = new StringBuilder();
            for (Integer integer : dq) {
                sb.append(integer);
            }
            result.offer(sb.toString());
            return;
        }
        for (int i = 0; i < stones.length; i++) {
            if (findZero(i, stones)) continue;
            pick(i, stones);
            DFS(level + 1, choice, stones, k);
            rollback(i, stones);
        }
    }

    // 하나를 골라서 나머지를 깎아주는 함수
    public void pick(int cur, int[] stones) {
        stones[cur] += 2;
        for (int i = 0; i < stones.length; i++) {
            stones[i]--;
        }
        dq.offerLast(cur);
    }

    public void rollback(int cur, int[] stones) {
        stones[cur] -= 2;
        for (int i = 0; i < stones.length; i++) {
            stones[i]++;
        }
        dq.removeLast();
    }

    public boolean findZero(int point, int[] stones) {
        for (int i = 0; i < stones.length; i++) {
            if (i != point && stones[i] == 0) {
                return true;
            }
        }
        return false;
    }

}
