package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeeHouse {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int now = 1;
        int result = 1;

        while (N > now) {
            now += 6 * result;
            result += 1;
        }
        System.out.println(result);
    }
}
