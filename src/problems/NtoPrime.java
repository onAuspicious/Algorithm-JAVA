package problems;

import java.util.ArrayList;

public class NtoPrime {

    public int solution(int n, int k) {
        // make n진법
        String string = changeToN(k, n);
        ArrayList<Integer> save = new ArrayList<>();
        int max = 0;
        int result = 0;
        int num = 0;

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != '0') {
                num *= 10;
                num += string.charAt(i) - '0';
            } else {
                if (num != 0) {
                    max = Math.max(max, num);
                    save.add(num);
                }
                num = 0;
            }
        }
        if (num != 0) {
            save.add(num);
        }

        boolean state;
        for (Integer val : save) {
            state = true;
            for (int i = 2; i < val/2; i++) {
                if (val % i == 0) {
                    state = false;
                    break;
                }
            }
            if (state && val != 1) {
                result++;
            }
        }
        return result;
    }

    public String changeToN(int k, int value) {
        StringBuilder stringBuilder = new StringBuilder();
        while (value >= 1) {
            stringBuilder.insert(0, value % k);
            value /= k;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        NtoPrime ntoPrime = new NtoPrime();
        int solution = ntoPrime.solution(130130, 10);
        System.out.println(solution);
    }
}
