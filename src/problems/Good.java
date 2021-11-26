package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Good {

    static int[] numbers;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        String[] input = br.readLine().split(" ");
        int result = 0;

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(numbers);

        for (int i = 0; i < n; i++) {
            if (find(i)) {
                result++;
            }
        }
        System.out.println(result);
    }

    public static boolean find(int cur) {
        int number = numbers[cur];
        int lt = 0, rt = n - 1;

        while (lt < rt) {
            if (lt == cur) {
                lt++;
                continue;
            }
            if (rt == cur) {
                rt--;
                continue;
            }
            if (numbers[lt] + numbers[rt] < number) {
                lt++;
            } else if (numbers[lt] + numbers[rt] > number) {
                rt--;
            } else {
                return true;
            }
        }
        return false;
    }
}
