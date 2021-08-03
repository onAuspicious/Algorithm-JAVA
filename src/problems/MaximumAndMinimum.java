package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumAndMinimum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maximum = -1000000;
        int minimum = 10000000;

        int n = Integer.parseInt(br.readLine());
        String[] list = br.readLine().split(" ");

        for (String i : list) {
            if (Integer.parseInt(i) < minimum) {
                minimum = Integer.parseInt(i);
            }
            if (Integer.parseInt(i) > maximum) {
                maximum = Integer.parseInt(i);
            }
        }
        System.out.println(minimum + " " + maximum);
    }
}
