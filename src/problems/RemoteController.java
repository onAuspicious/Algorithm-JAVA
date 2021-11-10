package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class RemoteController {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if (m > 0 && m < 10) {
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < m; i++) {
                set.add(Integer.parseInt(input[i]));
            }
        } else if (m == 10) {
            System.exit(0);
        }

        boolean state1 = true;
        boolean state2 = true;
        int tmp1, tmp2;
        int cur = 0;
        while (state1 && state2) {
            tmp1 = n + cur;
            tmp2 = Math.max(0, n - cur);
            if (tmp1 == 0 && !set.contains(0)) {
                state1 = false;
            }
            while (tmp1 != 0) {
                state1 = false;
                if (set.contains(tmp1 % 10)) {
                    state1 = true;
                    break;
                }
                tmp1 /= 10;
            }
            if (tmp2 == 0 && !set.contains(0)) {
                state2 = false;
            }
            while (tmp2 != 0) {
                state2 = false;
                if (set.contains(tmp2 % 10)) {
                    state2 = true;
                    break;
                }
                tmp2 /= 10;
            }
            cur++;
        }

        cur--;
        int result;

        // tmp2
        if (!state2) {
            result = Integer.toString(n - cur).length() + cur;
        } else {
            result = Integer.toString(n + cur).length() + cur;
        }

        System.out.println(Math.min(result, Math.abs(n - 100)));
    }
}
