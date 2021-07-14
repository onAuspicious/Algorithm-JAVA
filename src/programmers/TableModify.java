package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TableModify {
    HashMap<Integer, Integer[]> table = new HashMap<>();
    Stack<Integer[]> removed = new Stack<>();

    public String solution(int n, int k, String[] cmd) {
        int now = k;
        StringBuilder result = new StringBuilder();
        // table making
        table.put(0, new Integer[]{null, 0, 1});
        table.put(n-1, new Integer[]{n - 2, n - 1, null});
        for (int i = 1; i < n-1; i++) {
            table.put(i, new Integer[]{i-1, i, i+1});
        }

        for (String c : cmd) {
            String[] command = c.split(" ");
            if (command[0].equals("D")) {
                now = downNow(Integer.parseInt(command[1]), now);
            } else if (command[0].equals("U")) {
                now = upNow(Integer.parseInt(command[1]), now);
            } else if (command[0].equals("C")) {
                Integer[] tableNow = table.get(now);
                removeNow(now);
                if (tableNow[2] == null) {
                    now = table.get(tableNow[0])[1];
                } else {
                    now = table.get(tableNow[2])[1];
                }
            } else {
                restore();
            }
        }

        for (int i = 0; i < n; i++) {
            if (table.containsKey(i)) {
                result.append("O");
            } else {
                result.append("X");
            }
        }

        return result.toString();
    }

    public int downNow(int k, int now) {
        for (int i = 0; i < k; i++) {
            now = table.get(now)[2];
        }
        return now;
    }

    public int upNow(int k, int now) {
        for (int i = 0; i < k; i++) {
            now = table.get(now)[0];
        }
        return now;
    }

    public void removeNow(int now) {
        Integer[] remove = table.remove(now);
        if (remove[0] == null) {
            Integer[] right = table.get(remove[2]);
            right[0] = null;
            table.replace(remove[2], right);
        } else if (remove[2] == null) {
            Integer[] left = table.get(remove[0]);
            left[2] = null;
            table.replace(remove[0], left);
        } else {
            Integer[] left = table.get(remove[0]);
            Integer[] right = table.get(remove[2]);
            left[2] = right[1];
            right[0] = left[1];
            table.replace(remove[0], left);
            table.replace(remove[2], right);
        }
        removed.add(remove);
    }

    public void restore() {
        Integer[] restore = removed.pop();
        table.put(restore[1], restore);
        if (restore[0] == null) {
            Integer[] right = table.get(restore[2]);
            right[0] = restore[1];
            table.replace(right[1], right);
        } else if (restore[2] == null) {
            Integer[] left = table.get(restore[0]);
            left[2] = restore[1];
            table.replace(left[1], left);
        } else {
            Integer[] left = table.get(restore[0]);
            Integer[] right = table.get(restore[2]);
            right[0] = restore[1];
            left[2] = restore[1];
            table.replace(left[1], left);
            table.replace(right[1], right);
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        TableModify tableModify = new TableModify();
        String solution = tableModify.solution(n, k, cmd);
        System.out.println(solution);
    }
}
