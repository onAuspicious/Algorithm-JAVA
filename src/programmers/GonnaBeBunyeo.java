package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GonnaBeBunyeo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] memo = new int[15][15];
        int k;
        int n;
        for (int i = 0; i < 15; i++) {
            memo[0][i] = i + 1;
            memo[i][0] = 1;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                memo[i][j] = memo[i][j - 1] + memo[i - 1][j];
            }
        }
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            System.out.println(memo[k][n-1]);
        }
    }
}
