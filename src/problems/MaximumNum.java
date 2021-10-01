package problems;

import java.util.Arrays;

public class MaximumNum {

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        int size = numbers.length;
        String[] arr = new String[size];
        int r = 0;

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.toString(numbers[i]);
            r += numbers[i];
        }
        if (r == 0) return "0";

        Arrays.sort(arr, (a, b) -> {
            String left = a + a + a + a;
            String right = b + b + b + b;
            for (int i = 0; i < 4; i++) {
                if (left.charAt(i) > right.charAt(i)) {
                    return -1;
                } else if (left.charAt(i) < right.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        });

        for (String s : arr){
            sb.append(s);
        }

        return sb.toString();
    }
}
