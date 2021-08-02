package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bertran {
    public List<Integer> solution(int[] memo) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 2; i < memo.length; i++) {
            if (memo[i] == 0) {
                for (int j = i; j < memo.length; j += i) {
                    memo[j] = 1;
                }
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Bertran main = new Bertran();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] memo = new int[247000];
        int cnt = 0;

        List<Integer> result = main.solution(memo);

        while (true) {
            int i = Integer.parseInt(br.readLine());
            if (i == 0) {
                break;
            } else {
                for (Integer integer : result) {
                    if (integer <= i*2) {
                        if (integer > i) {
                            cnt++;
                        }
                    } else {
                        break;
                    }
                }
                System.out.println(cnt);
                cnt = 0;
            }
        }
    }
}
