package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Card_2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i < n + 1; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            deque.removeFirst();
            deque.add(deque.removeFirst());
        }
        System.out.println(deque.getFirst());
    }
}
