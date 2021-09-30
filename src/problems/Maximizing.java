package problems;

import java.util.ArrayDeque;

public class Maximizing {

    static ArrayDeque<String> exp = new ArrayDeque<>();
    static long result = 0;

    public static long solution(String expression) {
        addToExp(expression);
        DFS(0, new String[]{"-", "+", "*"}, new ArrayDeque<>());
        return result;
    }

    static void DFS(int level, String[] e, ArrayDeque<String> arr) {
        if (level == 3) {
            // method start
            long tmp = 0L;
            ArrayDeque<String> copy = new ArrayDeque<>();
            for (String s : exp) {
                copy.offerLast(s);
            }
            for (String s : arr) {
                if (s.equals("+")) {
                    plus(copy);
                } else if (s.equals("-")) {
                    minus(copy);
                } else{
                    multiple(copy);
                }
                for (String a : copy) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
            for (String s : copy) {
                System.out.print(s + " ");
            }
            minus(copy);
            System.out.println();
            System.out.println(copy.peekFirst());
            result = Math.max(result, Math.abs(Long.parseLong(copy.removeFirst())));
        } else {
            for (int i = 0; i < 3; i++) {
                if (!arr.contains(e[i])) {
                    arr.offerLast(e[i]);
                    DFS(level + 1, e, arr);
                    arr.removeLast();
                }
            }
        }
    }

    static void plus(ArrayDeque<String> copy) {
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            String now = copy.removeFirst();
            if (now.equals("+")) {
                i++;
                String last = copy.removeLast();
                String first = copy.removeFirst();
                long tmp = Long.parseLong(last) + Long.parseLong(first);
                copy.offerLast(Long.toString(tmp));
            } else {
                copy.offerLast(now);
            }
        }
    }

    static void minus(ArrayDeque<String> copy) {
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            String now = copy.removeFirst();
            if (now.equals("-")) {
                i++;
                String last = copy.removeLast();
                String first = copy.removeFirst();
                long tmp = Long.parseLong(last) - Long.parseLong(first);
                copy.offerLast(Long.toString(tmp));
            } else {
                copy.offerLast(now);
            }
        }
    }

    static void multiple(ArrayDeque<String> copy) {
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            String now = copy.removeFirst();
            if (now.equals("*")) {
                i++;
                String last = copy.removeLast();
                String first = copy.removeFirst();
                long tmp = Long.parseLong(last) * Long.parseLong(first);
                copy.offerLast(Long.toString(tmp));
            } else {
                copy.offerLast(now);
            }
        }
    }

    static void addToExp(String expression) {
        int tmp = 0;
        for(int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                tmp = (tmp * 10) + expression.charAt(i) - '0';
            } else {
                exp.offerLast(Integer.toString(tmp));
                tmp = 0;
                exp.offerLast(Character.toString(expression.charAt(i)));
            }
        }
        exp.offerLast(Integer.toString(tmp));
    }

    public static void main(String[] args) {
        String expression = "50*6-3*2";
        System.out.println(solution(expression));
    }
}
