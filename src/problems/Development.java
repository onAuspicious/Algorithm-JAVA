package problems;

import java.util.*;

public class Development {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        int size = progresses.length;
        ArrayList<Integer> list = new ArrayList<>();

        // init tasks
        for (int i = 0; i < size; i++) {
            int now = 100 - progresses[i];
            if (now % speeds[i] == 0) {
                tasks.offerLast(now / speeds[i]);
            } else {
                tasks.offerLast(now / speeds[i] + 1);
            }
        }

        int day = tasks.peekFirst();
        int cnt = 0;

        while (!tasks.isEmpty()) {
            if (tasks.peekFirst() <= day) {
                tasks.pollFirst();
                cnt++;
            } else {
                list.add(cnt);
                cnt = 0;
                day = tasks.peekFirst();
            }
        }
        list.add(cnt);

        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
