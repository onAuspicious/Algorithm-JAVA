package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntegerTriangle {

    static int[][] res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        res = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] line = new int[i + 1];
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < i + 1; j++) {
                line[j] = Integer.parseInt(input[j]);
            }
            res[i] = line;
        }

        if (n == 1) {
            System.out.println(res[0][0]);
        } else {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < res[i].length; j++) {
                    if (j == 0) {
                        res[i][j] += res[i - 1][0];
                    } else if (j == res[i].length-1) {
                        res[i][j] += res[i - 1][res[i].length - 2];
                    } else {
                        res[i][j] += Math.max(res[i - 1][j], res[i - 1][j - 1]);
                    }
                    result = Math.max(res[i][j], result);
                }
            }
            System.out.println(result);
        }
    }
}
