package problems;

import java.util.*;

public class WordChange {

    static ArrayDeque<String> dq = new ArrayDeque<>();
    static HashSet<String> check = new HashSet<>();

    public int solution(String begin, String target, String[] words) {
        int cnt = 0;
        dq.offerLast(begin);
        check.add(begin);

        while(!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                String now = dq.removeFirst();
                for (int j = 0; j < words.length; j++) {
                    if (oneDif(words[j], now) && !check.contains(words[j])) {
                        dq.offerLast(words[j]);
                        check.add(words[j]);
                    }
                }
                if (now.equals(target)) return cnt;
            }
            cnt++;
        }
        return 0;
    }

    static boolean oneDif(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) cnt++;
        }
        return cnt == 1;
    }
}
