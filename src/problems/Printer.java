package problems;

import java.util.*;

public class Printer {

    static ArrayDeque<Task> tasks = new ArrayDeque<>();
    static int[] check = new int[10];
    static int max;

    static class Task {
        int num;
        int priority;
        public Task(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }
    }

    public int solution(int[] priorities, int location) {
        int size = priorities.length;
        int cnt = 0;

        for (int i = 0; i < size; i++) {
            tasks.offerLast(new Task(i, priorities[i]));
            check[priorities[i]]++;
        }
        max = findMax();

        while (true) {
            Task now = tasks.removeFirst();
            if (now.priority >= max) {
                check[now.priority]--;
                cnt++;
                if (now.num == location) break;
            } else {
                tasks.offerLast(now);
            }
            max = findMax();
        }

        return cnt;
    }

    public int findMax() {
        for (int i = 9; i > 0; i--) {
            if (check[i] > 0) {
                return i;
            }
        }
        return 0;
    }
}
