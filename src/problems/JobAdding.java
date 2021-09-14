package problems;

import java.util.HashMap;
import java.util.Map;

public class JobAdding {

    public String solution(String[] table, String[] languages, int[] preference) {
        String[] result = new String[]{"", "0"};
        Map<String, Integer> map = new HashMap<>();

        // init language, preference in map
        for (int i = 0; i < languages.length; i++) {
            map.put(languages[i], preference[i]);
        }

        // search result
        for (String s : table) {
            String[] split = s.split(" ");
            int point = 0;
            for (int i = 1; i < 6; i++) {
                if (map.containsKey(split[i])) {
                    point += map.get(split[i]) * (6 - i);
                }
            }
            if (Integer.parseInt(result[1]) < point) {
                result[0] = split[0];
                result[1] = Integer.toString(point);
            } else if (Integer.parseInt(result[1]) == point) {
                if (result[0].compareTo(split[0]) > 0) {
                    result[0] = split[0];
                    result[1] = Integer.toString(point);
                }
            }
        }

        return result[0];
    }
}
