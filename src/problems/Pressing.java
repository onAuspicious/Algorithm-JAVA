package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pressing {

    static int cur = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));
    }

    static int solution(String str) {
        int cnt = 0;
        int front = 0;
        while (cur < str.length()) {
            char now = str.charAt(cur);
            if (Character.isDigit(now)) {
                cur++;
                cnt++;
                front = now - '0';
            } else if (now == '(') {
                cur++;
                cnt += front * solution(str);
                cnt--;
            } else {
                cur++;
                return cnt;
            }
        }
        return cnt;
    }
}
