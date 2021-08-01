package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reversed {
    int saveI;
    int reverse;

    public boolean solution(int i, int target) {
        saveI = i;
        reverse = 0;

        while (saveI != 0) {
            reverse = reverse * 10 + saveI % 10;
            saveI /= 10;
        }
        return target != i - reverse;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reversed main = new Reversed();
        int N = Integer.parseInt(br.readLine());
        int i = N + 1;
        boolean state = true;

        while (main.solution(i, N)) {
            i++;
            if (i > i * 2) {
                System.out.println(-1);
                state = false;
                break;
            }
        }
        if (state) {
            System.out.println(i);
        }

    }
}
