package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class GoldBahGuess {

    public Map<Integer, Boolean> makePrimeHash() {
        HashMap<Integer, Boolean> result = new HashMap<>();
        int[] memo = new int[10001];

        for (int i = 2; i < 10001; i++) {
            if (memo[i] == 0) {
                for (int j = i; j < 10001; j+=i) {
                    memo[j] = 1;
                }
                result.put(i, true);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        GoldBahGuess main = new GoldBahGuess();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int now;
        int left = 0; int right = 0;

        Map<Integer, Boolean> prime = main.makePrimeHash();

        for (int i = 0; i < n; i++) {
            now = Integer.parseInt(br.readLine());

            for (int j = 2; j < now/2+1; j++) {
                if (prime.getOrDefault(j, false) && prime.getOrDefault(now-j, false)) {
                    left = j;
                    right = now - j;
                }
            }
            System.out.println(left + " " + right);
        }
    }
}
