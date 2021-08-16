package problems;

import java.io.IOException;
import java.util.*;

public class MinimumTranslateLoad {

    static ArrayList<ArrayList<Integer>> maps = new ArrayList<>();
    static Deque<int[]> deque = new ArrayDeque<>();
    static int[] visitStation;
    static int[] visitRail;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<ArrayList<Integer>> subway = new ArrayList<>();
        visitRail = new int[Integer.parseInt(input[1])];
        visitStation = new int[Integer.parseInt(input[0])+1];

        for (int i = 0; i < Integer.parseInt(input[0]) + 1; i++) {
            subway.add(new ArrayList<>());
        }

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            maps.add(new ArrayList<>());
        }

        int next;
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            while (true) {
                if ((next = sc.nextInt()) == -1) {
                    break;
                } else {
                    subway.get(next).add(i);
                    maps.get(i).add(next);
                }
            }
        }
        deque.add(new int[]{sc.nextInt(), 0});
        int end = sc.nextInt();
        sc.close();

        while (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                int[] pop = deque.pop();
                visitStation[pop[0]] = 1;
                for (Integer rail : subway.get(pop[0])) {
                    if (visitRail[rail] == 0) {
                        visitRail[rail] = 1;
                        for (Integer station : maps.get(rail)) {
                            if (visitStation[station] == 0 && subway.get(station).size() > 1) {
                                visitStation[station] = 1;
                                deque.add(new int[]{station, pop[1] + 1});
                            }
                            if (station == end) {
                                System.out.println(pop[1]);
                                System.exit(0);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
