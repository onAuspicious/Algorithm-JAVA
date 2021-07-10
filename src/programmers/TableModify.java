package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class TableModify {
    public String solution(int n, int k, String[] cmd) {
        ArrayList<Integer> table = new ArrayList<>();
        Stack<int[]> removed = new Stack<>();
        StringBuilder result = new StringBuilder();
        int now = k;
        // init table
        for (int i = 0; i < n; i++) {
            table.add(i);
            result.append("O");
        }

        for (String c : cmd) {
            String[] split = c.split(" ");
            if (split[0].equals("D")) {
                now += Integer.parseInt(split[1]);
            } else if (split[0].equals("U")) {
                now -= Integer.parseInt(split[1]);
            } else if (split[0].equals("C")) {
                Integer remove = table.remove(now);
                result.setCharAt(now, 'X');
                removed.add(new int[]{now, remove});
                if (now >= table.size()) {
                    now = table.size() - 1;
                }
            } else {
                int[] pop = removed.pop();
                table.add(pop[0], pop[1]);
                result.setCharAt(pop[0], 'O');
                if (pop[0] <= now) now += 1;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
        TableModify tableModify = new TableModify();
        String solution = tableModify.solution(n, k, cmd);
        ArrayList<String> strings = new ArrayList<>();

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayList.add(i + 10);
        }
    }
}
