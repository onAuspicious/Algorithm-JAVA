package problems;

import java.util.*;

public class DiskController {

    static class Task implements Comparable<Task>{
        int offerTime;
        int spendTime;
        public Task(int offerTime, int spendTime) {
            this.offerTime = offerTime;
            this.spendTime = spendTime;
        }

        @Override
        public int compareTo(Task task) {
            return this.spendTime - task.spendTime;
        }
    }

    public int solution(int[][] jobs) {
        int time = 0;  // time now
        int size = jobs.length;
        int result = 0;
        Task[] tasks = new Task[size];

        for (int i = 0; i < size; i++) {
            tasks[i] = new Task(jobs[i][0], jobs[i][1]);
        }
        Arrays.sort(tasks, new Comparator<Task>(){
            @Override
            public int compare(Task t1, Task t2) {
                if (t1.offerTime < t2.offerTime) {
                    return -1;
                } else if (t1.offerTime > t2.offerTime) {
                    return 1;
                } else {
                    return t1.spendTime - t2.spendTime;
                }
            }
        });

        PriorityQueue<Task> pq = new PriorityQueue<>();

        for (int i = 0; i < size; i++) {
            Task task = tasks[i];

            while (!pq.isEmpty() && time < task.offerTime) {
                Task pop = pq.poll();
                time += pop.spendTime;
                result += time - pop.offerTime;
            }

            if (time < task.offerTime) {
                time = task.offerTime + task.spendTime;
                result += task.spendTime;
            } else {
                pq.add(task);
            }
        }
        while (!pq.isEmpty()) {
            Task pop = pq.poll();
            time += pop.spendTime;
            result += time - pop.offerTime;
        }
        return result / size;
    }
}