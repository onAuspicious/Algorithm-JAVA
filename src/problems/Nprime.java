package problems;

import java.util.ArrayList;

public class Nprime {

    public int solution(int n, int k) {
        // make n진법
        String[] string = changeToN(k, n);
        ArrayList<Integer> save = new ArrayList<>();
        int max = 0;
        int result = 0;
        int num = 0;

        for (String s : string) {
            if (!s.equals("") && Character.isDigit(s.charAt(0))) {
                save.add(Integer.parseInt(s));
            }
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

    public String[] changeToN(int k, int value) {
        StringBuilder stringBuilder = new StringBuilder();
        while (value >= 1) {
            stringBuilder.insert(0, value % k);
            value /= k;
        }
        return stringBuilder.toString().split("0");
    }

    public static void main(String[] args) {
        NtoPrime ntoPrime = new NtoPrime();
        int solution = ntoPrime.solution(123, 10);
        System.out.println(solution);

        String[] a = "100".split("0");
        for (String s : a) {
            System.out.println("-" + s + "-");
        }
    }
}
