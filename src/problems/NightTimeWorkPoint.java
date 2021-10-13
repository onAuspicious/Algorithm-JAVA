package problems;

import java.util.Arrays;

public class NightTimeWorkPoint {

    public long solution(int n, int[] works) {
        Arrays.sort(works);
        int size = works.length;
        long result = 0;
        int cur = size - 1;

        while (n > 0 && works[0] != 0) {
            if (works[cur] == works[(cur - 1 + size) % size]) {
                works[cur]--;
                cur = (cur - 1 + size) % size;
            } else {
                works[cur]--;
                cur = size - 1;
            }
            n--;
        }

        for (int work : works) {
            result += (long) work * work;
        }
        return result;
    }
}
