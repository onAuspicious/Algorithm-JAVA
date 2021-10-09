package problems;

import java.util.Collections;
import java.util.PriorityQueue;

public class DoublePriorityQueue2 {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> removedMax = new PriorityQueue<>();
    static PriorityQueue<Integer> removedMin = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] operations) {
        for (String operation : operations) {
            String[] split = operation.split(" ");
            int n = Integer.parseInt(split[1]);
            if (split[0].equals("I")) {
                push(n);
            } else {
                if (n == 1) {
                    maxPop();
                } else {
                    minPop();
                }
            }
        }

        int[] result = new int[2];
        // 조건 -> result 변경
        while (!removedMin.isEmpty() && removedMin.peek().equals(maxHeap.peek())) {
            removedMin.poll();
            maxHeap.poll();
        }
        while (!removedMax.isEmpty() && removedMax.peek().equals(minHeap.peek())) {
            removedMax.poll();
            minHeap.poll();
        }

        if (minHeap.isEmpty()) {
            return result;
        }
        result[0] = maxHeap.peek();
        result[1] = minHeap.peek();
        return result;
    }

    ///////// function //////////
    public static void push(int n) {
        maxHeap.offer(n);
        minHeap.offer(n);
    }

    public static void maxPop() {
        while (!removedMin.isEmpty() && removedMin.peek().equals(maxHeap.peek())) {
            removedMin.poll();
            maxHeap.poll();
        }
        if (!maxHeap.isEmpty()) {
            removedMax.offer(maxHeap.poll());
        }
    }

    public static void minPop() {
        while (!removedMax.isEmpty() && removedMax.peek().equals(minHeap.peek())) {
            removedMax.poll();
            minHeap.poll();
        }
        if (!minHeap.isEmpty()) {
            removedMin.offer(minHeap.poll());
        }
    }
}
