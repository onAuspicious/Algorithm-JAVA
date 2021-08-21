package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coin0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int money = Integer.parseInt(input[1]);
        int[] coins = new int[n];
        int result = 0;
        int coin;

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = n - 1; i > -1; i--) {
            coin = money / coins[i];
            result += coin;
            money -= coin * coins[i];
            if (money == 0) {
                break;
            }
        }
        System.out.println(result);
    }
}
