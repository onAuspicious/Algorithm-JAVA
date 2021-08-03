package problems;

import java.util.Scanner;

public class StudyWord {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] memo = new int[26];
        byte[] next = scanner.next().toLowerCase().getBytes();
        int maximum = 0;
        int result = -1;

        for (byte b : next) {
            memo[b - 97] += 1;
        }

        for (int i = 0; i < memo.length; i++) {
            if (memo[i] > maximum) {
                result = i;
                maximum = memo[i];
            } else if (memo[i] == maximum) {
                result = -1;
            }
        }

        if (result == -1) {
            System.out.println("?");
        } else {
            System.out.println((char) (result + 65));
        }
    }
}
