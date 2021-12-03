package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CuriousMinho {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] original = new int[n][n];
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                original[i][j] = Integer.parseInt(input[j]);
                copy[i][j] = original[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i == j || j == k || i == k) {
                        continue;
                    }

                    if (original[j][k] == original[j][i] + original[i][k]) {
                        copy[j][k] = 0;
                    }

                    if (original[j][k] > original[j][i] + original[i][k]) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        int result = 0;

        for (int[] ints : copy) {
            for (int i : ints) {
                result += i;
            }
        }
        System.out.println(result / 2);
    }
}
