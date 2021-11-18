package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CheckPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int gcdVal = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            gcdVal = gcd(gcdVal, arr[i] - arr[i - 1]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(gcdVal); i++) {
            if (i * i == gcdVal) {
                result.add(i);
            } else if (gcdVal % i == 0) {
                result.add(i);
                result.add(gcdVal / i);
            }
        }

        Collections.sort(result);

        for (Integer integer : result) {
            sb.append(integer).append(' ');
        }
        sb.append(gcdVal);
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
