package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class MinimumHeap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int input;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (priorityQueue.isEmpty()) {
                    sb.append(0).append('\n');
                } else {
                    sb.append(priorityQueue.poll()).append('\n');
                }
            } else {
                priorityQueue.add(input);
            }
        }
        System.out.println(sb);
    }
}
