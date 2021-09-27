package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetOut {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][2];
        int[] money = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        for (int i = n; i > 0; i--) {
            int endTime = arr[i][0] + i;
            if (endTime <= n + 1) {
                money[i] = Math.max(money[i + 1], arr[i][1] + money[endTime]);
            } else {
                money[i] = money[i + 1];
            }
        }
        System.out.println(money[1]);
    }
}
