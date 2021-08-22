package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;

public class StackSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i < n + 1; i++) {
            stack.add(i);
            sb.append('+').append('\n');

            while (!stack.isEmpty()) {
                if (stack.peek().equals(deque.getFirst())) {
                    stack.pop();
                    deque.removeFirst();
                    sb.append('-').append('\n');
                } else {
                    break;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
