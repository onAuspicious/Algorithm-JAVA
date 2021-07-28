package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfDigit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] memo = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String result = Integer.toString(A * B * C);
        for (int i = 0; i < result.length(); i++) {
            memo[result.charAt(i) - '0'] += 1;
        }

        for (int i : memo) {
            System.out.println(i);
        }
    }
}
