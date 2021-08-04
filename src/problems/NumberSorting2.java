package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class NumberSorting2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int tmp;
        HashMap<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tmp = Integer.parseInt(br.readLine());
            if (memo.containsKey(tmp)) {
                memo.replace(tmp, memo.get(tmp) + 1);
            } else {
                memo.put(tmp, 1);
            }
        }
        ArrayList<Integer> keys = new ArrayList<>(memo.keySet());
        Collections.sort(keys);

        for (Integer key : keys) {
            for (int i = 0; i < memo.get(key); i++) {
                sb.append(key).append('\n');
            }
        }
        System.out.println(sb);
    }
}
