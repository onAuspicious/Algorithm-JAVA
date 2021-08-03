package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DivideSum {

    int result;

    public int makeDivideSum(int n) {
        result = n;
        while (n != 0) {
            result += n % 10;
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        DivideSum main = new DivideSum();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean result = true;

        if (n < 63) {
            for (int i = n-1; i > -1; i--) {
                if (main.makeDivideSum(n - i) == n) {
                    System.out.println(n-i);
                    result = false;
                    break;
                }
            }
        } else {
            for (int i = 63; i > 0; i--) {
                if (main.makeDivideSum(n - i) == n) {
                    System.out.println(n-i);
                    result = false;
                    break;
                }
            }
        }
        if (result) System.out.println(0);
    }
}
