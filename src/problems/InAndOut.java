package problems;

import java.util.*;

public class InAndOut {

    public static int[] solution(int[] enter, int[] leave) {
        int cur = 0;
        int size = enter.length;
        int[] result = new int[size];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size ; i++) {
            for (Integer key : map.keySet()) {
                map.replace(key, map.get(key) + 1);
            }
            map.put(enter[i], map.size());

            while (cur < size) {
                if (map.containsKey(leave[cur])) {
                    result[leave[cur]-1] = map.remove(leave[cur]);
                    cur++;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] enter = new int[]{1,4,2,3};
        int[] leave = new int[]{2, 1, 3, 4};
        int[] solution = solution(enter, leave);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
