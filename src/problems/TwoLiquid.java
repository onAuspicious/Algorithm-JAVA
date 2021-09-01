package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoLiquid {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int minimum = Integer.MAX_VALUE;
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int lt = 0; int rt = n-1;
        int[] result = new int[2];
        int tmp;
        while (lt < rt) {
            if (arr[lt] >= 0) {
                if (arr[lt] + arr[lt + 1] < minimum) {
                    result[0] = arr[lt];
                    result[1] = arr[lt + 1];
                }
                break;
            } else if (arr[rt] <= 0) {
                if (Math.abs(arr[rt] + arr[rt - 1]) < minimum) {
                    result[0] = arr[rt - 1];
                    result[1] = arr[rt];
                }
                break;
            } else {
                if ((tmp = Math.abs(arr[rt] + arr[lt])) < minimum) {
                    result[0] = arr[lt];
                    result[1] = arr[rt];
                    minimum = tmp;
                }
                if (Math.abs(arr[lt]) <= arr[rt]) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }
        sb.append(result[0]).append(" ").append(result[1]);
        System.out.println(sb);
    }
}