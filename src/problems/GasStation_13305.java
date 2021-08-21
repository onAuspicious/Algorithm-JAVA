package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GasStation_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] loads = br.readLine().split(" ");
        String[] prices = br.readLine().split(" ");
        long maxPrice = Long.parseUnsignedLong(prices[0]);
        long result = 0;
        long now;

        for (int i = 0; i < n - 1; i++) {
            if (maxPrice <= (now = Long.parseUnsignedLong(prices[i]))) {
                result += maxPrice * Long.parseUnsignedLong(loads[i]);
            } else {
                result += now * Long.parseUnsignedLong(loads[i]);
                maxPrice = now;
            }
        }
        System.out.println(Long.toUnsignedString(result));
    }
}
