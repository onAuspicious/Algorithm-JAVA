package programmers;

import java.util.*;

public class JewelShopping {

    public int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        Map<String, Integer> gemHashMap = new HashMap<>();
        Collections.addAll(gemSet, gems);
        int[] result = {1, gems.length};
        int start = 0;

        for (int i = 0; i < gems.length; i++) {
            Integer temp = gemHashMap.getOrDefault(gems[i], 0);
            if (gemHashMap.containsKey(gems[i])) {
                gemHashMap.replace(gems[i], temp + 1);
            } else {
                gemHashMap.put(gems[i], temp + 1);
            }

            while (start <= i & gemHashMap.size() == gemSet.size()) {
                if (i-start < result[1]-result[0]) {
                    result = new int[] {start + 1, i + 1};
                }

                gemHashMap.replace(gems[start], gemHashMap.get(gems[start]) - 1);
                if (gemHashMap.get(gems[start]) == 0) {
                    gemHashMap.remove(gems[start]);
                }
                start += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        JewelShopping jewelShopping = new JewelShopping();
        int[] solution = jewelShopping.solution(gems);
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
