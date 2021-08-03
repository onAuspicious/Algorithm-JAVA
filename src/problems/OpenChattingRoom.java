package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenChattingRoom {
    public String[] solution(String[] record) {
        // Enter 된 아이디들을 저장, 삭제 <uid, name> 형식
        HashMap<String, String> recordMap = new HashMap<>();
        ArrayList<String[]> res = new ArrayList<>();

        // record 처리
        for (String rec : record) {
            String[] split = rec.split(" ");

            if (split[0].equals("Enter")) {
                if (recordMap.containsKey(split[1])) {
                    recordMap.replace(split[1], split[2]);
                } else {
                    recordMap.put(split[1], split[2]);
                }
                String[] tmp = {split[1], "님이 들어왔습니다."};
                res.add(tmp);
            } else if (split[0].equals("Leave")) {
                String[] tmp = {split[1], "님이 나갔습니다."};
                res.add(tmp);
            } else {
                recordMap.replace(split[1], split[2]);
            }
        }

        String[] result = new String[res.size()];

        for (int i = 0; i < res.size(); i++) {
            String[] tmp = res.get(i);
            result[i] = recordMap.get(tmp[0]) + tmp[1];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] record = {"Leave uid1234","Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan", "Leave uid4567", "Enter uid4567 Prodo", "Leave uid4567"};
        OpenChattingRoom openChattingRoom = new OpenChattingRoom();
        String[] solution = openChattingRoom.solution(record);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
