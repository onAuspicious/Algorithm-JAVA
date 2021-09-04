package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberOfK {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());
        long rt = n;
        long lt = 1;
        long cnt;
        long mid;
        long result = 0;

        while (lt <= rt) {
            cnt = 0;
            mid = (lt + rt) / 2;
            for (int i = 1; i < n + 1; i++) {
                cnt += Math.min(mid / i, n);
            }
            if (cnt < k) {
                lt = mid + 1;
            } else {
                result = mid;
                rt = mid - 1;
            }
        }
        System.out.println(result);
    }
}
