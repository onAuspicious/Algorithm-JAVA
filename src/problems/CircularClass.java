package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CircularClass {

    static class Pay{
        int pay;
        int day;

        public Pay(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // college
        Pay[] info = new Pay[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int pay = Integer.parseInt(input[0]);
            int day = Integer.parseInt(input[1]);
            info[i] = new Pay(pay, day);
        }

        Arrays.sort(info, Comparator.comparingInt(o -> o.day));

        int cur = 0, benefit = 0;
        PriorityQueue<Pay> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.pay));

        for (int day = 1; day <= 10000; day++) {
            while (cur < n && info[cur].day <= day) {
                if (pq.size() < day) {
                    pq.offer(info[cur]);
                    benefit += info[cur].pay;
                } else {
                    if (pq.peek().pay < info[cur].pay) {
                        benefit -= pq.poll().pay;
                        pq.offer(info[cur]);
                        benefit += info[cur].pay;
                    }
                }
                cur++;
            }
        }

        System.out.println(benefit);
        br.close();
    }
}
