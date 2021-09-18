package problems;

import java.util.*;

public class FarstNode {

    public int solution(int n, int[][] edge) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();

        //init
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<Integer>());
        }

        for (int[] vertex: edge) {
            ArrayList<Integer> temp1 = graph.get(vertex[0]);
            ArrayList<Integer> temp2 = graph.get(vertex[1]);
            temp1.add(vertex[1]);
            temp2.add(vertex[0]);
            graph.replace(vertex[0], temp1);
            graph.replace(vertex[1], temp2);
        }

        boolean[] check = new boolean[n+1];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1); check[1] = true;
        List<Integer> save = new ArrayList<>();

        while (!dq.isEmpty()) {
            int size = dq.size();
            save.clear();
            for (int i = 0; i < size; i++) {
                int pop = dq.removeFirst();
                save.add(pop);
                for (int j: graph.get(pop)) {
                    if (!check[j]) {
                        dq.add(j);
                        check[j] = true;
                    }
                }
            }
        }
        return save.size();
    }
}
