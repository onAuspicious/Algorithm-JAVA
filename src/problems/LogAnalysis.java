package problems;

import java.util.*;
public class LogAnalysis {

    static HashMap<String, HashMap<Integer,Integer>> userMap = new HashMap<>();

    public String[] solution(String[] logs) {
        HashSet<String> result = new HashSet<>();
        for (String log : logs) {
            String[] data = log.split(" ");
            if (!userMap.containsKey(data[0])) {
                userMap.put(data[0], new HashMap<>());
            }
            userMap.get(data[0]).put(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
        }

        Set<String> keySet = userMap.keySet();
        String[] keys = new String[keySet.size()];
        int cur = 0;
        for (String key : keySet) {
            keys[cur++] = key;
        }

        for (int i = 0; i < keySet.size() - 1; i++) {
            HashMap<Integer, Integer> now = userMap.get(keys[i]);
            if (now.size() < 5) continue;
            for (int j = i + 1; j < keySet.size(); j++) {
                HashMap<Integer, Integer> next = userMap.get(keys[j]);
                if (now.size() != next.size()) continue;
                boolean equal = true;
                for (Integer key : now.keySet()) {
                    if (!next.containsKey(key)) {
                        equal = false;
                        break;
                    } else {
                        if (!now.get(key).equals(next.get(key))) {
                            equal = false;
                            break;
                        }
                    }
                }
                if (equal) {
                    result.add(keys[i]);
                    result.add(keys[j]);
                }
            }
        }
        if (result.size() == 0) {
            return new String[]{"None"};
        }
        String[] answer = new String[result.size()];
        cur = 0;
        for (String key : result) {
            answer[cur++] = key;
        }
        return answer;
    }
}
