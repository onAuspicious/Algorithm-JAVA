package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MakeBig {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[1]);

        String num = br.readLine();

        System.out.println(solution(num, m));
    }

    public static String solution(String num, int remove) {
        ArrayDeque<Integer> numDeque = new ArrayDeque<>();
        for (int i = 0; i < num.length(); i++) {
            int now = num.charAt(i) - '0';
            if (numDeque.isEmpty()) {
                numDeque.offerLast(now);
                continue;
            }
            while (!numDeque.isEmpty() && remove > 0 && now > numDeque.peekLast()) {
                numDeque.removeLast();
                remove--;
            }
            numDeque.offerLast(now);
        }

        while (remove > 0 && !numDeque.isEmpty()) {
            numDeque.removeLast();
            remove--;
        }

        StringBuilder result = new StringBuilder();
        for (int i : numDeque) result.append(i);

        return result.toString();
    }
}
