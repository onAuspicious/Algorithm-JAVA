package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class CircledQueue {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int[] task = new int[Integer.parseInt(input[1])];
        int cnt;
        int result = 0;

        for (int i = 1; i < Integer.parseInt(input[0]) + 1; i++) {
            deque.add(i);
        }

        String[] tasks = br.readLine().split(" ");

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            task[i] = Integer.parseInt(tasks[i]);
        }

        for (int i : task) {
            cnt = 0;
            while (deque.getFirst() != i) {
                deque.add(deque.removeFirst());
                cnt++;
            }
            if (cnt > deque.size() / 2) {
                result += deque.size() - cnt;
            } else {
                result += cnt;
            }
            deque.removeFirst();
        }

        System.out.println(result);
    }
}
