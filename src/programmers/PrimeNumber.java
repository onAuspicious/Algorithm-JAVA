package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

    public void solution(int M, int N, int[] memo) {
        for (int i = 2; i < memo.length; i++) {
            if (memo[i] == 0) {
                memo[i] = 2;
                for (int j = i * 2; j < memo.length; j += i) {
                    memo[j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PrimeNumber main = new PrimeNumber();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = 100001;
        int sum = 0;

        int[] memo = new int[N + 1];

        main.solution(M, N, memo);

        for (int i = M; i < N + 1; i++) {
            if (memo[i] == 2) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
