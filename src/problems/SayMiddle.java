package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SayMiddle {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> Mheap = new PriorityQueue<>();
        PriorityQueue<Integer> mheap = new PriorityQueue<>();
        int input;
        int tmp;

        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (Mheap.size() <= mheap.size()) {
                Mheap.add(-input);
            } else {
                mheap.add(input);
            }
            if (!mheap.isEmpty() && !Mheap.isEmpty()) {
                if (mheap.peek() < -Mheap.peek()) {
                    tmp = mheap.poll();
                    mheap.add(-Mheap.poll());
                    Mheap.add(-tmp);
                }
            }
            sb.append(-Mheap.peek()).append('\n');
        }
        System.out.println(sb);
    }
}
