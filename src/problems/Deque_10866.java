package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Deque_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            if (input[0].equals("push_front")) {
                deque.offerFirst(Integer.parseInt(input[1]));
            } else if (input[0].equals("push_back")) {
                deque.offerLast(Integer.parseInt(input[1]));
            } else if (input[0].equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.removeFirst()).append('\n');
                }
            } else if (input[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.removeLast()).append('\n');
                }
            } else if (input[0].equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (input[0].equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (input[0].equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.getFirst()).append('\n');
                }
            } else {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.getLast()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
