package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Stack;

public class NAndM1 {

    static HashSet<Integer> memo = new HashSet<>();

    public void solution(int n, int m, Stack<Integer> list, StringBuilder sb) {
        if (list.size() == m) {
            for (Integer i : list) {
                sb.append(i).append(" ");
            }
            sb.append('\n');
            return;
        }
        for (int i = 1; i < n+1; i++) {
            if (!memo.contains(i)) {
                memo.add(i);
                list.add(i);
                solution(n, m, list, sb);
                list.pop();
                memo.remove(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NAndM1 main = new NAndM1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        Stack<Integer> list = new Stack<>();
        main.solution(Integer.parseInt(input[0]), Integer.parseInt(input[1]), list, sb);
        System.out.println(sb);
    }
}
