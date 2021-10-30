package problems;

import java.util.*;
public class XXPay {

    public int solution(String[] id_list, int k) {
        HashMap<String, Integer> couponMap = new HashMap<>();
        HashSet<String> today = new HashSet<>();
        int result = 0;

        for (String list : id_list) {
            String[] day_list = list.split(" ");
            for (String user : day_list) {
                if (today.contains(user)) continue;
                if (!couponMap.containsKey(user)) {
                    couponMap.put(user, 1);
                } else {
                    if (couponMap.get(user) < k) {
                        couponMap.put(user, couponMap.get(user) + 1);
                    }
                }
                today.add(user);
            }
            today.clear();
        }

        for (String key : couponMap.keySet()) {
            result += couponMap.get(key);
        }

        return result;
    }
}
