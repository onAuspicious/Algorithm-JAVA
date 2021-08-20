package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBDistance {

    static int[] R;
    static int[] G;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        R = new int[n]; G = new int[n]; B = new int[n];
        int r; int g; int b;
        int result = Integer.MAX_VALUE;

        String[] input = br.readLine().split(" ");
        R[0] = Integer.parseInt(input[0]);
        G[0] = Integer.parseInt(input[1]);
        B[0] = Integer.parseInt(input[2]);

        for (int i = 1; i < n; i++) {
            input = br.readLine().split(" ");
            r = Integer.parseInt(input[0]);
            g = Integer.parseInt(input[1]);
            b = Integer.parseInt(input[2]);

            for (int j = 0; j < 3; j++) {
                R[i] = Math.min(G[i - 1], B[i - 1]) + r;
                G[i] = Math.min(R[i - 1], B[i - 1]) + g;
                B[i] = Math.min(R[i - 1], G[i - 1]) + b;
            }
        }
        result = Math.min(R[n - 1], Math.min(G[n - 1], B[n - 1]));
        System.out.println(result);
    }
}
