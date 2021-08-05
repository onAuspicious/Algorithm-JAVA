package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NAndM2 {

    Stack<Integer> stack = new Stack<>();

    public void solution(int n, int m, int now, StringBuilder sb) {
        if (stack.size() == m) {
            for (Integer i : stack) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = now + 1; i < n+1; i++) {
            stack.add(i);
            solution(n, m, i, sb);
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        NAndM2 main = new NAndM2();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        main.solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]), 0,  sb);
        System.out.println(sb);
    }
}
