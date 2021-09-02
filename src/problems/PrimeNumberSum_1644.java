package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PrimeNumberSum_1644 {

    static ArrayList<Integer> primes = new ArrayList<>();

    static void find(int num, boolean[] arr) {
        for (int i = 2; i < num + 1; i++) {
            if (!arr[i]) {
                for (int j = i; j < num + 1; j += i) {
                    arr[j] = true;
                }
                primes.add(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[num + 1];
        find(num, arr);
        int lt = 0;
        int rt = 0;
        int result = 0;

        if (num == 1) {
            System.out.println(0);
        } else {
            int sum = primes.get(0);
            while (true) {
                if (sum > num) {
                    sum -= primes.get(lt);
                    lt++;
                } else {
                    if (sum == num) {
                        result++;
                    }
                    if (rt == primes.size() - 1) {
                        break;
                    }
                    rt++;
                    sum += primes.get(rt);
                }
            }
            System.out.println(result);
        }
    }
}
