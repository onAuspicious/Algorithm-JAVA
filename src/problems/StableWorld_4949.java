package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StableWorld_4949 {

    static boolean check(String input, Stack<Character> stack) {
        char now;
        for (int i = 0; i < input.length(); i++) {
            now = input.charAt(i);
            if (now == '(' || now == '[') {
                stack.add(now);
            } else if (now == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            } else if (now == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        String input;

        while (!(input = br.readLine()).equals(".")) {
            if (check(input, stack)) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
            stack.clear();
        }
        System.out.println(sb);
    }
}
