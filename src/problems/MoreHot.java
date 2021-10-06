package problems;

import java.util.PriorityQueue;

public class MoreHot {

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;

        for (int i : scoville) {
            pq.add(i);
        }

        while (pq.size() >= 2 && pq.peek() < K) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            int n = s1 + s2 * 2;
            pq.add(n);
            result++;
        }
        if (pq.peek() < K) return -1;
        return result;
    }
}
