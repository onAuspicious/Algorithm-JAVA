package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1037 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int now;
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            now = Integer.parseInt(input[i]);
            max = Math.max(max, now);
            min = Math.min(min, now);
        }
        System.out.println(max * min);
    }
}
