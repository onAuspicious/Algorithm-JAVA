package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fluid {

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] fluid = new int[n];
        int[] result = new int[2];
        int val = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            fluid[i] = Integer.parseInt(input[i]);
        }

        int lt = 0;
        int rt = n - 1;

        while (lt < rt) {
            boolean state = false;
            int abs = Math.abs(fluid[lt] + fluid[rt]);
            if (abs < val) {
                result[0] = fluid[lt];
                result[1] = fluid[rt];
                val = abs;
            }
            if (fluid[lt] >= 0 && fluid[rt] >= 0) {
                rt--;
            } else if (fluid[lt] < 0 && fluid[rt] >= 0) {
                if (Math.abs(fluid[lt]) <= fluid[rt]) {
                    rt--;
                } else {
                    lt++;
                }
            } else {
                lt++;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}
