package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class PrinterQueue {

    static ArrayDeque<int[]> deque = new ArrayDeque<>();
    static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    static int printerQueue(int goal) {
        int cnt = 0;

        while (true) {

            if (deque.getFirst()[0] == Math.abs(priorityQueue.peek())) {
                priorityQueue.poll();
                cnt++;
                if (deque.removeFirst()[1] == goal) {
                    return cnt;
                }
            } else {
                deque.add(deque.removeFirst());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                deque.add(new int[]{Integer.parseInt(line[j]), j});
                priorityQueue.add(-Integer.parseInt(line[j]));
            }
            sb.append(printerQueue(Integer.parseInt(input[1]))).append('\n');
            deque.clear();
            priorityQueue.clear();
        }
        System.out.println(sb);
    }
}
