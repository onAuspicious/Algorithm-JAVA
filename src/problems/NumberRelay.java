package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberRelay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int n = Integer.parseInt(input);
        long result = 0;

        while (n >= 10) {
            String now = Integer.toString(n);
            int len = now.length();
            int m = Integer.parseInt(now.charAt(0) - '1' + now.substring(1));
            result += (long) (m + 1) * len;
            n -= m + 1;
        }
        result += n;
        System.out.println(result);
    }
}
