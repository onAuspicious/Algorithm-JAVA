package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class AC_5430 {

    static ArrayDeque<Integer> deque = new ArrayDeque<>();
    static boolean state;
    static StringBuilder sb = new StringBuilder();

    static void solution(String[] task, int num, String input) {
        deque.clear();
        state = true;  // true: 정방향 false: 역방항
        String[] str = input.substring(1, input.length() - 1).split(",");

        for (String s : str) {
            if (!s.equals("")) {
                deque.add(Integer.parseInt(s));
            }
        }

        for (String s : task) {
            if (s.equals("R")) {
                state = !state;
            } else {
                if (!deque.isEmpty()) {
                    if (state) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                } else {
                    sb.append("error").append('\n');
                    return;
                }
            }
        }
        if (deque.isEmpty()) {
            sb.append("[]").append('\n');
            return;
        }
        sb.append("[");
        while (deque.size() > 1) {
            if (state) {
                sb.append(deque.removeFirst()).append(",");
            } else {
                sb.append(deque.removeLast()).append(",");
            }
        }
        sb.append(deque.removeFirst()).append("]").append('\n');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            solution(br.readLine().split(""), Integer.parseInt(br.readLine()), br.readLine());
        }
        System.out.println(sb);
    }
}
