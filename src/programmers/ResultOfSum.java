package programmers;

import java.util.Scanner;

public class ResultOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result = 0;

        for (int i = 1; i < N+1; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
