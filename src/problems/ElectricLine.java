package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ElectricLine {

    static ArrayList<int[]> queries = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            queries.add(new int[]{a, b});
            max = Math.max(max, Math.max(a, b));
        }

        int[] save = new int[max + 1];
        int[] dp = new int[max + 1];
        int result = 0;

        for (int[] query : queries) {
            save[query[0]] = query[1];
        }

        for (int i = 1; i <= max; i++) {
            int now = save[i];
            if (now > 0) {
                int cnt = 0;
                for (int j = i - 1; j > 0; j--) {
                    if (save[j] < now && save[j] != 0) {
                        cnt = Math.max(cnt, dp[j]);
                    }
                }
                dp[i] = cnt + 1;
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(n - result);
    }
}
