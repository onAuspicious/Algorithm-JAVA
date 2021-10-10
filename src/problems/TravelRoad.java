package problems;

import java.util.*;

public class TravelRoad {

    static int size;
    static HashMap<String, ArrayList<String>> graph = new HashMap<>();
    static HashMap<String, Integer> dupleMap = new HashMap<>();
    static TreeSet<String> result = new TreeSet<>();
    static ArrayDeque<String> save = new ArrayDeque<>();

    public static String[] solution(String[][] tickets) {
        size = 1 + tickets.length;
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                graph.put(ticket[0], new ArrayList<>());
            }
            graph.get(ticket[0]).add(ticket[1]);
            dupleMap.put(ticket[0] + ticket[1], dupleMap.getOrDefault(ticket[0] + ticket[1], 0) + 1);
        }
        save.offerLast("ICN");
        DFS("ICN");
        return result.first().split(" ");
    }

    static void DFS(String now) {
        if (save.size() == size) {
            StringBuilder sb = new StringBuilder();
            for (String s : save) {
                sb.append(s).append(" ");
            }
            result.add(sb.toString());
        } else {
            if (!graph.containsKey(now)) return;
            for (String s : graph.get(now)) {
                String tmp = now + s;
                if (dupleMap.get(tmp) > 0) {
                    dupleMap.replace(tmp, dupleMap.get(tmp) - 1);
                    save.offerLast(s);
                    DFS(s);
                    dupleMap.replace(tmp, dupleMap.get(tmp) + 1);
                    save.removeLast();
                }
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = new String[][]{{"ICN", "A"}, {"A", "B"}, {"A", "C"},{"C", "A"},{"B", "D"}};
        String[] solution = TravelRoad.solution(tickets);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
