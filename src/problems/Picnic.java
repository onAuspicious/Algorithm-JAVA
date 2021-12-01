package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Picnic {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int m = Integer.parseInt(input[2]);
        int cnt = 1;
        int removed;

        while ((removed = k % n) != m % n) {
            if (removed < m) {
                m -= removed;
            } else {
                m = n - removed + m;
            }
            n--;
            cnt++;
        }
        System.out.println(cnt);
    }
}
