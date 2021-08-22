package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RightBigNumber {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Stack<int[]> stack = new Stack<>();
        int[] result = new int[n];
        int now;

        for (int i = 0; i < n; i++) {
            now = Integer.parseInt(input[i]);
            if (!stack.isEmpty()) {
                while (now > stack.peek()[0]) {
                    result[stack.pop()[1]] = now;
                    if (stack.isEmpty()) {
                        break;
                    }
                }
            }
            stack.add(new int[]{now, i});
        }

        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                sb.append(-1).append(" ");
            } else {
                sb.append(result[i]).append(" ");
            }
        }

        System.out.println(sb);
    }
}
