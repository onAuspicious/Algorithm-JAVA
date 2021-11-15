package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class RoomNumber {

    static BigInteger result = new BigInteger("0");
    static BigInteger[] dp = new BigInteger[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= 50; i++) {
            dp[i] = new BigInteger("0");
        }

        searchMaximumRoomNumber(BigInteger.valueOf(0), 0, n, m, numbers);

        for (int i = 0; i <= 50; i++) {
            if (result.compareTo(dp[i]) < 0) {
                result = dp[i];
            }
        }
        System.out.println(result);
    }

    public static void searchMaximumRoomNumber(BigInteger num, int money, int n, int m, int[] numbers) {
        for (int i = n - 1; i >= 0; i--) {
            int nextMoney = numbers[i] + money;
            BigInteger next = new BigInteger(String.valueOf(num.multiply(BigInteger.valueOf(10)).add(BigInteger.valueOf(i))));
            if (nextMoney <= m && dp[nextMoney].compareTo(next) < 0) {
                dp[nextMoney] = next;
                searchMaximumRoomNumber(next, nextMoney, n, m, numbers);
            }
        }
    }
}
