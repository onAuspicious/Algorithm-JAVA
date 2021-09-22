package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial0Count {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int twoCnt = 0;
        int FiveCnt = 0;
        int TenCnt = 0;
        int result;

        for (int i = 1; i < input + 1; i++) {
            int now = i;
            while (true) {
                if (now % 10 == 0) {
                    TenCnt++;
                    now /= 10;
                } else if (now % 5 == 0) {
                    FiveCnt++;
                    now /= 5;
                } else if (now % 2 == 0) {
                    twoCnt++;
                    now /= 2;
                } else {
                    break;
                }
            }
        }
        result = TenCnt + Math.min(twoCnt, FiveCnt);
        System.out.println(result);
    }
}
