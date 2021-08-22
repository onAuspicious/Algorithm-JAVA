package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Zero_10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int input;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input != 0) {
                stack.add(input);
                result += input;
            } else {
                result -= stack.pop();
            }
        }
        System.out.println(result);
    }
}
