package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Tower {

    static class Top {
        int point;
        int height;

        public Top(int point, int height) {
            this.point = point;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Top[] towers = new Top[n];

        for (int i = 0; i < n; i++) {
            towers[i] = new Top(i + 1, Integer.parseInt(input[i]));
        }

        Stack<Top> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            Top now = towers[i];

            while (!stack.isEmpty() && stack.peek().height < now.height) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(' ');
            } else {
                sb.append(stack.peek().point).append(' ');
            }
            stack.push(now);
        }

        System.out.println(sb);
    }
}
