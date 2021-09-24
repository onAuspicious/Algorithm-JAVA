package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOIOI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        int result = 0;
        int cnt = 0;
        String input = br.readLine();

        for (int i = 0; i < length - 2; i++) {
            if (input.charAt(i) == 'I' && input.charAt(i + 1) == 'O' && input.charAt(i + 2) == 'I') {
                cnt++;
                if (cnt == n) {
                    result++;
                    cnt--;
                }
                i++; // i 는 2번 올라가게 됩니다.
            } else {
                cnt = 0;
            }
        }
        System.out.println(result);
    }
}
