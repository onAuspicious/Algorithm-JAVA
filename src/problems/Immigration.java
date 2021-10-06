package problems;

public class Immigration {
    public long solution(int n, int[] times) {
        long rt = Long.MAX_VALUE, lt = 0, mid, result = 0;
        int size = times.length;

        while (lt <= rt) {
            mid = (lt + rt) / 2;
            long cnt = 0;
            for (int i = 0; i < size; i++) {
                cnt += mid / times[i];
            }
            if (cnt >= n) {
                rt = mid - 1;
                result = mid;
            } else {
                lt = mid + 1;
            }
        }
        return result;
    }
}
