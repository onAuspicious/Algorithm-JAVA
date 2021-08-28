package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BFSnDFS {

    static final StringBuilder sb = new StringBuilder();
    static boolean[][] graph;
    static boolean[] dfsMemo;
    static boolean[] bfsMemo;


    static void DFS(int start, Set<Integer> memo) {
        if (memo.size() == graph.length - 1) {
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i] && !dfsMemo[i]) {
                sb.append(i).append(" ");
                dfsMemo[i] = true;
                DFS(i, memo);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        graph = new boolean[Integer.parseInt(input[0]) + 1][Integer.parseInt(input[0]) + 1];
        dfsMemo = new boolean[graph.length];
        bfsMemo = new boolean[graph.length];

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String[] line = br.readLine().split(" ");
            graph[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = true;
            graph[Integer.parseInt(line[1])][Integer.parseInt(line[0])] = true;
        }

        sb.append(Integer.parseInt(input[2])).append(" ");
        dfsMemo[Integer.parseInt(input[2])] = true;
        DFS(Integer.parseInt(input[2]), new HashSet<>());

        sb.append('\n').append(Integer.parseInt(input[2])).append(" ");
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.add(Integer.parseInt(input[2]));
        int pop;
        bfsMemo[deque.peekFirst()] = true;
        while (!deque.isEmpty()) {
            pop = deque.removeFirst();
            for (int i = 0; i < graph.length; i++) {
                if (graph[pop][i] && !bfsMemo[i]) {
                    deque.add(i);
                    bfsMemo[i] = true;
                    sb.append(i).append(" ");
                }
            }
        }
        System.out.println(sb);
    }
}
