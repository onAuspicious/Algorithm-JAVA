package problems;

import java.util.*;

public class Move110 {

    static ArrayDeque<Character> dq = new ArrayDeque<>();

    public String[] solution(String[] s) {
        for (int i = 0; i < s.length; i++) {
            s[i] = change(s[i]);
        }
        return s;
    }

    public static String change(String s) {
        StringBuilder sb = new StringBuilder();
        int c1 = 0, c0 = 0, size = s.length();
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '1') {
                dq.offerLast('1');
            } else {
                if (dq.size() < 2) {
                    while (!dq.isEmpty()) sb.append(dq.removeFirst());
                    sb.append(0);
                    continue;
                }
                dq.removeLast();
                dq.removeLast();
                cnt++;
            }
        }

        for (int i = 0; i < cnt; i++) {
            sb.append(110);
        }
        while (!dq.isEmpty()) {
            sb.append(dq.removeFirst());
        }

        return sb.toString();
    }
}
