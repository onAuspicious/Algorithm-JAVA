package problems;

import java.util.HashMap;
import java.util.Stack;

public class Parenthesis {

    public long solution(String[] arr1, String[] arr2) {
        HashMap<Integer, Long> arr1HashMap = new HashMap<>();
        HashMap<Integer, Long> arr2HashMap = new HashMap<>();
        checkCorrectArr1(arr1HashMap, arr1);
        checkCorrectArr2(arr2HashMap, arr2);


        long result = 0;
        for (int key : arr1HashMap.keySet()) {
            long v1 = arr1HashMap.getOrDefault(key, 0L);
            long v2 = arr2HashMap.getOrDefault(key, 0L);
            result += v1 * v2;
        }
        return result;
    }

    public void checkCorrectArr1(HashMap<Integer, Long> map, String[] arr) {
        Stack<Character> stack = new Stack<>();

        for (String s : arr) {
            boolean state = true;
            stack.clear();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (stack.isEmpty()) {
                        state = false;
                        break;
                    }
                    stack.pop();
                } else {
                    stack.push('(');
                }
            }
            if (!state) continue;
            map.put(stack.size(), map.getOrDefault(stack.size(), 0L) + 1);
        }
    }

    public void checkCorrectArr2(HashMap<Integer, Long> map, String[] arr) {
        Stack<Character> stack = new Stack<>();

        for (String s : arr) {
            stack.clear();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                        continue;
                    }
                    stack.push(')');
                } else {
                    stack.push('(');
                }
            }
            if (!stack.isEmpty() && stack.peek() == '(') {
                continue;
            }
            map.put(stack.size(), map.getOrDefault(stack.size(), 0L) + 1);
        }
    }
}
