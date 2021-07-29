package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HanSoo {

    public boolean solution(int num) {
        int dif = (num / 10) % 10 - num % 10;
        int before = num % 10;
        num /= 10;

        while (num != 0) {
            if (before + dif != num%10) {
                return false;
            }
            before = num % 10;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HanSoo hanSoo = new HanSoo();
        int N = Integer.parseInt(br.readLine());
        int result = 99;

        if (100 > N) {
            System.out.println(N);
        } else {
            for (int i = 100; i < N+1; i++) {
                if (hanSoo.solution(i)) {
                    result += 1;
                }
            }
            System.out.println(result);
        }
    }
}
