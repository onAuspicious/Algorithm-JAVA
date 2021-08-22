package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {

    static boolean checkVPS(Stack<Character> stack, String input) {
        for (int i = 0; i < input.length(); i++) {
            if (stack.isEmpty()) {
                if (input.charAt(i) == ')') {
                    return false;
                } else {
                    stack.add('(');
                    continue;
                }
            }
            if (input.charAt(i) == '(') {
                if (stack.peek() == ')') {
                    return false;
                } else {
                    stack.add('(');
                }
            } else {
                if (stack.peek() == ')') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (checkVPS(stack, input)) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
            stack.clear();
        }
        System.out.println(sb);
    }
}
