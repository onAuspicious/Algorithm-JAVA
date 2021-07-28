package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusCycle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = N;
        int count = 0;

        while (true) {
            now = (now % 10 + now / 10) % 10 + now % 10 * 10;
            count += 1;
            if (now == N) {
                System.out.println(count);
                break;
            }
        }
    }
}
