package problems;

import java.util.Scanner;

public class SumOfNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String numbers = scanner.next();
        int result = 0;
        for (int i = 0; i < N; i++) {
            result += Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }
        System.out.println(result);
    }
}
