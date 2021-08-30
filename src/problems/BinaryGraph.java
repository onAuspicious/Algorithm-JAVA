package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BinaryGraph {

    static Map<Integer, Integer> memo = new HashMap<>();

    static boolean check(ArrayList<ArrayList<Integer>> graph) {
        memo.clear();
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int length;
        int pop;
        for (int j = 1; j < graph.size(); j++) {
            if (memo.containsKey(j)) {
                continue;
            }
            deque.add(j);
            memo.put(j, -1);
            while (!deque.isEmpty()) {
                length = deque.size();
                for (int i = 0; i < length; i++) {
                    pop = deque.removeFirst();
                    for (Integer integer : graph.get(pop)) {
                        if (memo.getOrDefault(integer, 0) == 0) {
                            deque.add(integer);
                            if (memo.get(pop) == -1) {
                                memo.put(integer, 1);
                            } else {
                                memo.put(integer, -1);
                            }
                        } else {
                            if (memo.get(integer).equals(memo.get(pop))) {
                                return false;
                            }
                        }
                    }
                }
            }
        }


        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int line = Integer.parseInt(input[1]);
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 0; j < node + 2; j++) {
                list.add(new ArrayList<>());
            }
            for (int j = 0; j < line; j++) {
                String[] split = br.readLine().split(" ");
                if (split[0].equals(split[1])) {
                    continue;
                }
                list.get(Integer.parseInt(split[0])).add(Integer.parseInt(split[1]));
                list.get(Integer.parseInt(split[1])).add(Integer.parseInt(split[0]));
            }
            if (check(list)) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }
}
