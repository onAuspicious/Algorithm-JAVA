package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestBitonicArray {

    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new int[n];
        int[] up = new int[n];
        int[] down = new int[n];
        int result = 0;
        String[] split = br.readLine().split(" ");

        // init input
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(split[i]);
        }

        // upside
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (input[i] > input[j]) {
                    up[i] = Math.max(up[i], up[j] + 1);
                }
            }
            if (up[i] == 0) {
                up[i]++;
            }
            result = Math.max(result, up[i]);
        }

        // downside 뒤에서 부터
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (input[i] > input[j]) {
                    down[i] = Math.max(down[i], down[j] + 1);
                }
            }
            if (down[i] == 0) {
                down[i]++;
            }
            result = Math.max(result, down[i]);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (input[i] > input[j]) {
                    result = Math.max(result, up[i] + down[j]);
                }
            }
        }
        System.out.println(result);
    }
}
