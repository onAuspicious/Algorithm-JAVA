package problems;

import java.util.Stack;

public class PairRemove {
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.add(s.charAt(i));
            } else if (s.charAt(i) == stack.lastElement()) {
                stack.pop();
            } else {
                stack.add(s.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "baabaa";
        PairRemove pairRemove = new PairRemove();
        System.out.println(pairRemove.solution(s));
    }
}
