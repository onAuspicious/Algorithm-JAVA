package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfTwoNum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(arr);

        int goal = Integer.parseInt(br.readLine());
        int lt = 0;
        int rt = n - 1;
        int result = 0;
        int now;

        while (lt < rt) {
            now = arr[lt] + arr[rt];
            if (now == goal) {
                result++;
                lt++;
            } else if (now < goal) {
                lt++;
            } else {
                rt--;
            }
        }
        System.out.println(result);
    }
}
