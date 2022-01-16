package problems;


import java.util.HashMap;
import java.util.HashSet;

public class ReportResultMail {

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> userMap = new HashMap<>();
        HashSet<String>[] reported = new HashSet[id_list.length];
        int[] result = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            userMap.put(id_list[i], i);
            reported[i] = new HashSet<>();
        }

        for (String r : report) {
            String[] split = r.split(" ");
            reported[userMap.get(split[1])].add(split[0]);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (reported[i].size() >= k) {
                for (String reporter : reported[i]) {
                    result[userMap.get(reporter)]++;
                }
            }
        }

        return result;
    }
}
