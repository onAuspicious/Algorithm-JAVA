package problems;

import java.util.Scanner;

public class RepeatStrings {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] next = scanner.nextLine().split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < next[1].length(); j++) {
                for (int k = 0; k < Integer.parseInt(next[0]); k++) {
                    stringBuilder.append(next[1].charAt(j));
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
