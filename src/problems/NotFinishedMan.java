package problems;

import java.util.HashMap;

public class NotFinishedMan {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> participants = new HashMap<>();
        String result = "";

        for (String p : participant) {
            if (!participants.containsKey(p)) {
                participants.put(p, 1);
            } else {
                participants.replace(p, participants.get(p) + 1);
            }
        }

        for (String c : completion) {
            participants.replace(c, participants.get(c) - 1);
            if (participants.get(c) == 0) {
                participants.remove(c);
            }
        }
        for (String key : participants.keySet()) {
            result = key;
        }
        return result;
    }

    public static void main(String[] args) {
        NotFinishedMan notFinishedMan = new NotFinishedMan();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(notFinishedMan.solution(participant, completion));
    }
}
