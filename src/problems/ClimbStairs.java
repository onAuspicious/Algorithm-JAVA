package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbStairs {

    static int[] list1;
    static int[] list2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        list1 = new int[n];
        list2 = new int[n];

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        if (n < 3) {
            System.out.println(list[0] + list[1]);
        } else {
            list1[0] = list[0];
            list1[1] = list[1];
            list2[0] = list[0];
            list2[1] = list[0] + list[1];

            for (int i = 2; i < n; i++) {
                if (i == n - 1) {
                    list1[i] = list2[i - 2] + list[i];
                    list2[i] = list1[i - 1] + list[i];
                } else {
                    list1[i] = Math.max(list1[i - 1], list2[i - 2] + list[i]);
                    list2[i] = Math.max(list2[i - 1], list1[i - 1] + list[i]);
                }
            }
            System.out.println(Math.max(list1[n - 1], list2[n - 1]));
        }
    }
}
