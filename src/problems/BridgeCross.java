package problems;

public class BridgeCross {

    public int solution(int[] stones, int k) {
        // find maximum
        int size = stones.length;
        int rt = Integer.MAX_VALUE, lt = 1;
        int answer = 0;

        // binary search
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                if (mid > stones[i]) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                if (cnt == k) break;
            }
            if (cnt == k) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }
        return answer;
    }
}
