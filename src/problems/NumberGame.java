package problems;

import java.util.*;

public class NumberGame {
    static ArrayDeque<Integer> a = new ArrayDeque<>();
    static ArrayDeque<Integer> b = new ArrayDeque<>();

    public int solution(int[] A, int[] B) {
        int result = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i : A) a.offerFirst(i);
        for (int i : B) b.offerFirst(i);

        while (!a.isEmpty()) {
            if (a.peekFirst() < b.peekFirst()) {
                result++;
                a.pollFirst();
                b.pollFirst();
            } else {
                if (a.peekFirst() < b.peekLast()) {
                    result++;
                }
                a.pollFirst();
                b.pollLast();
            }
        }
        return result;
    }
}
