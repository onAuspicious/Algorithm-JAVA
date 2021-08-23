package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class JosephsProblem {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int now = 0;
        int dist = Integer.parseInt(input[1]);

        for (int i = 1; i < Integer.parseInt(input[0]) + 1; i++) {
            deque.add(i);
        }

        sb.append('<');

        while (!deque.isEmpty()) {
            for (int i = 0; i < dist - 1; i++) {
                deque.add(deque.removeFirst());
            }
            if (deque.size() != 1) {
                sb.append(deque.removeFirst()).append(", ");
            } else {
                sb.append(deque.removeFirst());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
