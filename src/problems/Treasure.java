package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Treasure {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int S = 0;
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>((o1, o2) -> o2 - o1);

        String[] a = br.readLine().split(" ");
        String[] b = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            A.offer(Integer.parseInt(a[i]));
            B.offer(Integer.parseInt(b[i]));
        }

        for (int i = 0; i < n; i++) {
            S += A.poll() * B.poll();
        }

        System.out.println(S);
    }
}
