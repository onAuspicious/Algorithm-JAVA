package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class PostOffice {

    static class Office {
        int x;
        int a;

        public Office(int x, int a) {
            this.x = x;
            this.a = a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Office[] offices = new Office[n];
        int result = 0;
        long diff = 100000000000000L, s1 = 0, s2 = 0;

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            offices[i] = new Office(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            s1 += Integer.parseInt(input[1]);
        }

        Arrays.sort(offices, Comparator.comparingInt(o -> o.x));

        for (int i = 0; i < n; i++) {
            s2 += offices[i].a;
            long d = Math.abs(s1 - s2);
            if (diff > d) {
                result = offices[i].x;
                diff = d;
            }
            s1 -= offices[i].a;
        }

        System.out.println(result);
    }
}
