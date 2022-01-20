package problems;

import java.util.*;

public class WolfAndSheep {

    static class Node {
        int now;
        int sheep;
        int wolf;
        HashSet<Integer> visit;

        public Node(int now, int sheep, int wolf, HashSet<Integer> visit) {
            this.now = now;
            this.sheep = sheep;
            this.wolf = wolf;
            this.visit = visit;
        }
    }

    public int solution(int[] info, int[][] edges) {
        ArrayList<Integer>[] tree = new ArrayList[info.length];
        int result = 1;

        for (int i = 0; i < info.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
        }

        ArrayDeque<Node> dq = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();

        set.add(0);
        dq.offer(new Node(0, 1, 0, set));

        while (!dq.isEmpty()) {
            Node now = dq.removeFirst();
            Set<Integer> visit = now.visit;

            for (int v : visit) {
                for (int next : tree[v]) {
                    if (!visit.contains(next)) {
                        // wolf
                        if (info[next] == 0) {
                            HashSet<Integer> nextSet = copy(visit, next);
                            dq.offerLast(new Node(next, now.sheep + 1, now.wolf, nextSet));
                            result = Math.max(result, now.sheep + 1);
                        } else if (info[next] == 1 && now.sheep - now.wolf - 1 > 0) {
                            HashSet<Integer> nextSet = copy(visit, next);
                            dq.offerLast(new Node(next, now.sheep, now.wolf + 1, nextSet));
                        }
                    }
                }
            }
        }

        return result;
    }

    public HashSet<Integer> copy(Set<Integer> now, int next) {
        HashSet<Integer> set = new HashSet<>(now);
        set.add(next);
        return set;
    }
}
