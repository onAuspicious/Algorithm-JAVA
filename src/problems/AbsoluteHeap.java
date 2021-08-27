package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class AbsoluteHeap {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> plus = new PriorityQueue<>();
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int input;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input < 0) {
                minus.add(-input);
            } else if (input > 0) {
                plus.add(input);
            } else {
                if (!minus.isEmpty() && !plus.isEmpty()) {
                    if (minus.peek() > plus.peek()) {
                        sb.append(plus.poll()).append('\n');
                    } else {
                        sb.append(-minus.poll()).append('\n');
                    }
                } else if (!minus.isEmpty()) {
                    sb.append(-minus.poll()).append('\n');
                } else if (!plus.isEmpty()) {
                    sb.append(plus.poll()).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
        }
        System.out.println(sb);
    }
}
