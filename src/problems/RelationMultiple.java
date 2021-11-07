package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RelationMultiple {

    static int n;
    static long b;
    static int[][] matrix;
    static HashMap<Long, int[][]> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        b = Long.parseLong(input[1]);
        matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(input[j]) % 1000;
            }
        }

        int[][] result = solution(b);
        for (int[] ans : result) {
            for (int i : ans) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static int[][] solution(long m) {
        if (m == 1) {
            return matrix;
        }
        if (dp.containsKey(m)) {
            return dp.get(m);
        }
        int[][] multiple;
        if (m % 2 == 0) {
            multiple = multiple(solution(m / 2), solution(m / 2));
        } else {
            multiple = multiple(multiple(solution(m / 2), solution(m / 2)), matrix);
        }
        dp.put(m, multiple);
        return multiple;
    }

    public static int[][] multiple(int[][] m1, int[][] m2) {
        int[][] result = new int[n][n];
        int sum;
        //left row
        for (int i = 0; i < n; i++) {
            // right col
            for (int j = 0; j < n; j++) {
                sum = 0;
                // left col
                for (int k = 0; k < n; k++) {
                    sum += m1[i][k] * m2[k][j];
                }
                result[i][j] = sum % 1000;
            }
        }
        return result;
    }
}
