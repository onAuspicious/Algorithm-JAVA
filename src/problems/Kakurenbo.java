package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Kakurenbo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int maximum = Math.max(n, m) * 3 / 2;
        int cnt = 0;
        int length;
        int[] points = new int[maximum + 1];
        int pop;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(n);
        points[n] = 1;

        while (points[m] == 0) {
            length = deque.size();
            for (int i = 0; i < length; i++) {
                pop = deque.removeFirst();
                if (pop - 1 >= 0 && points[pop - 1] == 0) {
                    points[pop - 1] = 1;
                    deque.add(pop - 1);
                }
                if (pop + 1 <= maximum && points[pop + 1] == 0) {
                    points[pop + 1] = 1;
                    deque.add(pop + 1);
                }
                if (2 * pop <= maximum && points[2 * pop] == 0) {
                    points[2 * pop] = 1;
                    deque.add(2 * pop);
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
