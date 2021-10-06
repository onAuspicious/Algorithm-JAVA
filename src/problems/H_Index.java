package problems;

import java.util.Arrays;

public class H_Index {

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;

        int result = 0;
        for (int i = size - 1; i >= 0; i--) {
            if (citations[i] >= size - i) {
                result++;
            } else break;
        }
        return result;
    }
}
