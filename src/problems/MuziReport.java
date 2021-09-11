package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MuziReport {

    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reported = new HashMap<>();
        Map<String, Integer> mapping_id = new HashMap<>();
        int[] result = new int[id_list.length];
        boolean[] isActive = new boolean[id_list.length];

        // mapping id
        for (int i = 0; i < id_list.length; i++) {
            mapping_id.put(id_list[i], i);
        }

        // count reported
        for (String rp : report) {
            String[] split = rp.split(" ");
            if (!reported.containsKey(split[1])) {
                HashSet<String> set = new HashSet<>();
                set.add(split[0]);
                reported.put(split[1], set);
            } else {
                Set<String> set = reported.get(split[1]);
                set.add(split[0]);
                reported.replace(split[1], set);
            }
        }

        // key to count
        for (String key : reported.keySet()) {
            Set<String> reporters = reported.get(key);
            int mail_num = reporters.size() / k;
            if (mail_num > 0) {
                for (String report_id : reporters) {
                    result[mapping_id.get(report_id)] += mail_num;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        MuziReport muziReport = new MuziReport();
        muziReport.solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"}, 2);
    }
}
