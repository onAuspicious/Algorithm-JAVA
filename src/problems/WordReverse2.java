package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class WordReverse2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Character> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        boolean state = true;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                state = false;
                move();
                sb.append(input.charAt(i));
            } else if (input.charAt(i) == '>') {
                state = true;
                sb.append(input.charAt(i));
            } else {
                if (state) {
                    if (input.charAt(i) == ' ') {
                        move();
                        sb.append(' ');
                    } else {
                        dq.offerLast(input.charAt(i));
                    }
                } else {
                    sb.append(input.charAt(i));
                }
            }
        }
        move();
        System.out.println(sb);
    }

    static void move() {
        while (!dq.isEmpty()) {
            sb.append(dq.removeLast());
        }
    }
}
