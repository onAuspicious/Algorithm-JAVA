package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Queue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                deque.add(input[1]);
            } else if (input[0].equals("pop")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.removeFirst()).append('\n');
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
