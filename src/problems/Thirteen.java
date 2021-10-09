package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Thirteen {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        int[] arr = new int[input.length];
        int sum = 0;

        for (int i = 0; i < input.length; i++) {
            int now = Integer.parseInt(input[i]);
            arr[i] = now;
            sum += now;
        }
        if (sum % 3 != 0) {
            System.out.println(-1);
        } else {
            Arrays.sort(arr);
            if (arr[0] == 0) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = arr.length - 1; i >= 0; i--) {
                    stringBuilder.append(arr[i]);
                }
                System.out.println(stringBuilder);
            } else {
                System.out.println(-1);
            }
        }
    }
}
