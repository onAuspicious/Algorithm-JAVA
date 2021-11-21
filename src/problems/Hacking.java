package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hacking {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static class Move implements Comparable<Move>{
        int node;
        int time;

        public Move(int node, int time) {
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Move move) {
            return this.time - move.time;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine()); // test case
        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            hacking(Integer.parseInt(input[0]),Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        }
        System.out.println(sb);
    }

    public static void hacking(int n, int d, int c) throws IOException {
        PriorityQueue<Move> hacked = new PriorityQueue<>();
        int[] times = new int[n + 1];
        Arrays.fill(times, Integer.MAX_VALUE);

        //init graph
        ArrayList<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < d; i++) {
            String[] input = br.readLine().split(" ");
            graph[Integer.parseInt(input[1])].add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[2])});
        }

        hacked.add(new Move(c, 0));
        times[c] = 0;

        while (!hacked.isEmpty()) {
            Move now = hacked.poll();
            if (now.time > times[now.node]) {
                continue;
            }
            for (int[] vertex : graph[now.node]) {
                int node = vertex[0];
                int time = vertex[1];
                if (time + now.time < times[node]) {
                    hacked.offer(new Move(node, time + now.time));
                    times[node] = time + now.time;
                }
            }
        }

        int[] result = findMaxNumberAndCnt(times);
        sb.append(result[0]).append(' ').append(result[1]).append('\n');
    }

    public static int[] findMaxNumberAndCnt(int[] arr) {
        int result = 0;
        int cnt = 0;
        for (int i : arr) {
            if (i != Integer.MAX_VALUE) {
                result = Math.max(result, i);
                cnt++;
            }
        }
        return new int[]{cnt, result};
    }
}
