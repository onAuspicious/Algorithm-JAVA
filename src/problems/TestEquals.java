package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class TestEquals {

    static HashSet<String> set = new HashSet<>();

    static String solution(String[] register_id, String target_id) {
        set.addAll(Arrays.asList(register_id));

        StringBuilder s = new StringBuilder();
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < target_id.length(); i++) {
            if (Character.isDigit(target_id.charAt(i))) {
                n.append(target_id.charAt(i));
            } else {
                s.append(target_id.charAt(i));
            }
        }
        String S = s.toString();
        String N = n.toString();
        int num = Integer.parseInt(N);
        String now = S + N;

        while (set.contains(now)) {
            now = S + num;
            num++;
            System.out.println(now);
        }
        return now;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] register_id = new String[]{"abc1", "abc2", "abc3", "cat1", "cat2", "cat3"};
        String target_id = br.readLine();
        String result = solution(register_id, target_id);
        System.out.println(result);
    }
}
