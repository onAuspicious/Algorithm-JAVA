package problems;

import java.util.ArrayList;

public class SelfNumber {

    int[] memo = new int[10001];

    public void solution(int i) {
        int result = i;

        while (i != 0) {
            result += i % 10;
            i /= 10;
        }
        if (result <= 10000) {
            memo[result] = 1;
        }
    }

    public static void main(String[] args){
        SelfNumber selfNumber = new SelfNumber();
        int[] memo = selfNumber.memo;
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10001; i++) {
            if (memo[i] == 0) {
                result.add(i);
                memo[i] = 1;
                selfNumber.solution(i);
            } else {
                selfNumber.solution(i);
            }
        }

        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}
