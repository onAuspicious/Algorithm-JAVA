package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class JosephSequence {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dq.offerLast(i);
        }
        sb.append("<");
        while (!dq.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                dq.offerLast(dq.removeFirst());
            }
            if (dq.size() > 1) {
                sb.append(dq.removeFirst()).append(", ");
            } else {
                sb.append(dq.removeFirst());
            }
        }
        sb.append(">");
        System.out.println(sb);
    }
}
