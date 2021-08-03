package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumberFast {

    public void solution(int M, int N, int[] memo) {

        for (int i = 2; i < memo.length; i++) {
            if (memo[i] == 0) {
                for (int j = i; j < memo.length; j += i) {
                    memo[j] = 1;
                }
                if (i >= M && i <= N) {
                    System.out.println(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        PrimeNumberFast main = new PrimeNumberFast();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        int[] memo = new int[N + 1];

        main.solution(M, N, memo);
    }
}
