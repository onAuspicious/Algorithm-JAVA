package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Minimum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] result = {0, 0};

        for (int i = 1; i < 10; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > result[1]) {
                result[0] = i;
                result[1] = num;
            }
        }
        System.out.println(result[1]);
        System.out.println(result[0]);
    }
}
