package programmers;

import java.util.Scanner;

public class AsciiCode {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        byte[] bytes = next.getBytes();
        System.out.println(bytes[0]);
    }
}
