package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Stack_10828 {

    static void push(Stack<Integer> stack, int i) {
        stack.push(i);
    }

    static int pop(Stack<Integer> stack) {
        return stack.pop();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("push")) {
                push(stack, Integer.parseInt(input[1]));
            } else if (input[0].equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (input[0].equals("pop")) {
                if (!stack.isEmpty()) {
                    sb.append(pop(stack)).append('\n');
                } else {
                    sb.append(-1).append('\n');
                }
            } else if (input[0].equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(stack.lastElement()).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
