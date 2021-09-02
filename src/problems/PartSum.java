package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int lt = 0;
        int rt = 1;
        int result = 100000001;
        String[] line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int sum = arr[0] + arr[1];

        while (true) {
            if (sum >= s) {
                result = Math.min(result, rt - lt + 1);
                if (rt - lt == 1) {
                    break;
                }
                sum -= arr[lt];
                lt++;
            } else {
                if (rt < n-1) {
                    rt++;
                    sum += arr[rt];
                } else {
                    break;
                }
            }
        }
        if (result == 100000001) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}
