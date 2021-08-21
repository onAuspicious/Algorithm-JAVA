package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(list);

        int result = 0;
        int time = 0;

        for (int i : list) {
            time +=  i;
            result += time;
        }
        System.out.println(result);
    }
}
