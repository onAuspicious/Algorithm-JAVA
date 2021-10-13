package problems;

import java.util.*;

public class BalloonBoom {

    static Stack<Integer> stack = new Stack<>();

    public int solution(int[] a) {
        for (int now : a) {
            while (stack.size() >= 2) {
                int before = stack.pop();
                if (before < now || before < stack.peek()) {
                    stack.push(before);
                    break;
                }
            }
            stack.push(now);
        }
        return stack.size();
    }
}
