package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SearchingMinimum {

    static int[] result;
    static PriorityQueue<Integer> heap1 = new PriorityQueue<>();
    static PriorityQueue<Integer> heap2 = new PriorityQueue<>();
    static Deque<Integer> window = new ArrayDeque<>();

    public static void solution(int n, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i < n) {
                window.add(numbers[i]);
                heap1.add(numbers[i]);
            } else {
                heap2.offer(window.poll());
                window.add(numbers[i]);
                while (!heap2.isEmpty()) {
                    if (heap2.peek().equals(heap1.peek())) {
                        heap1.poll();
                        heap2.poll();
                    } else {
                        break;
                    }
                }
                heap1.offer(numbers[i]);
            }
            result[i] = heap1.peek();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        String[] line = br.readLine().split(" ");
        result = new int[Integer.parseInt(input[0])];
        int[] numbers = new int[Integer.parseInt(input[0])];

        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }
        solution(Integer.parseInt(input[1]), numbers);

        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
