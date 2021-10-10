package problems;

import java.util.*;

public class BadUser {

    static HashSet<String> dupleCheck = new HashSet<>();
    static HashMap<String, ArrayList<String>> map = new HashMap<>();
    static LinkedList<String> save = new LinkedList<>();

    public int solution(String[] user_id, String[] banned_id) {
        for (String b : banned_id) {
            map.put(b, new ArrayList<>());
            ArrayList<String> list = map.get(b);
            for (String u : user_id) {
                if (check(b, u)) {
                    list.add(u);
                }
            }
        }
        DFS(0, banned_id.length, user_id, banned_id);
        return dupleCheck.size();
    }

    static void DFS(int level, int end, String[] user_id, String[] banned_id) {
        if (level == end) {
            StringBuilder sb = new StringBuilder();
            Collections.sort(save);
            for (String s : save) {
                sb.append(s);
            }
            String now = sb.toString();
            dupleCheck.add(now);
        } else {
            ArrayList<String> list = map.get(banned_id[level]);
            for (String s : list) {
                if (save.contains(s)) continue;
                save.add(s);
                DFS(level + 1, end, user_id, banned_id);
                save.remove(s);
            }
        }
    }

    static boolean check (String b, String u) {
        if (b.length() != u.length()) return false;
        for (int i = 0; i < b.length(); i++){
            if (b.charAt(i) == '*') continue;
            if (b.charAt(i) != u.charAt(i)) return false;
        }
        return true;
    }
}
