package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FractionSearch {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = 0;
        int cnt = 1;
        int left;
        int right;

        while (now + cnt < N) {
            now += cnt;
            cnt += 1;
        }
        if (cnt % 2 == 0) {
            left = N - now;
            right = cnt - N + now + 1;
        } else {
            left = cnt - N + now + 1;
            right = N - now;
        }
        System.out.println(left + "/" + right);
    }
}
