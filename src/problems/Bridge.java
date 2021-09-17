package problems;

import java.util.Arrays;

public class Bridge {

    public int solution(int distance, int[] rocks, int n) {
        int lt = 0;
        int rt = distance;
        int size = rocks.length;
        int[] new_rocks = new int[size + 1];
        int result = 0;

        Arrays.sort(rocks);

        for (int i = 0; i < size; i++) {
            new_rocks[i] = rocks[i];
        }
        new_rocks[size] = distance;

        while (lt <= rt) {
            int removed = 0;
            int now = 0;
            int mid = (lt + rt) / 2;

            for (int i = 0; i <= size; i++){
                if (new_rocks[i] - now >= mid) {
                    now = new_rocks[i];
                } else {
                    removed++;
                }
            }

            if (removed > n) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                result = mid;
            }
        }
        return result;
    }
}
