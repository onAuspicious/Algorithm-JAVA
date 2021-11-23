package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Scale {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(weights);

        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (sum + 1 < weights[i]) {
                break;
            }
            sum += weights[i];
        }
        System.out.println(sum + 1);
        br.close();
    }
}
