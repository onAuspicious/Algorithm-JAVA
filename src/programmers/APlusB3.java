package programmers;

import java.util.Scanner;

public class APlusB3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < N; i++) {
            String[] now = scanner.nextLine().split(" ");
            System.out.println(Integer.parseInt(now[0]) + Integer.parseInt(now[1]));
        }
    }
}
