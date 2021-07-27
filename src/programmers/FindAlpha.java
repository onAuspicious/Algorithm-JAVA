package programmers;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FindAlpha {

    public static void main(String[] args) {
        int[] result = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        byte[] bytes = word.getBytes(StandardCharsets.US_ASCII);
        for (int i = 0; i < bytes.length; i++) {
            if (result[bytes[i] - 97] == -1) {
                result[bytes[i] - 97] = i;
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
