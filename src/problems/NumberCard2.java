package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class NumberCard2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> memo = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        for (String s : br.readLine().split(" ")) {
            if (memo.containsKey(s)) {
                memo.replace(s, memo.get(s) + 1);
            } else {
                memo.put(s, 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (String s : br.readLine().split(" ")) {
            if (memo.get(s) == null) {
                sb.append(0).append(" ");
            } else {
                sb.append(memo.get(s)).append(" ");
            }
        }
        System.out.println(sb);
    }
}
