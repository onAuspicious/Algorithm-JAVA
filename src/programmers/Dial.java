package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Dial {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] log = br.readLine().split("");
        int result = 0;

        for (String s : log) {
            if (s.equals("Z")) {
                result += 10;
            } else {
                result += (s.getBytes(StandardCharsets.UTF_8)[0] - 65) / 3 + 3;
            }
        }
        System.out.println(result);
    }
}
