package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RecommandNewId {

    public String solution(String new_id) {
        // 1
        new_id = new_id.toLowerCase();

        // 2
        char now;
        StringBuilder second = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            now = new_id.charAt(i);
            if (Character.isDigit(now) || Character.isAlphabetic(now) || now == '-' || now == '_' || now == '.') {
                second.append(now);
            }
        }
        new_id = second.toString();

        // 3
        int cnt = 0;
        StringBuilder third = new StringBuilder();
        for (int i = 0; i < new_id.length(); i++) {
            now = new_id.charAt(i);
            if (now == '.') {
                cnt++;
                if (cnt == 2) {
                    cnt = 1;
                    continue;
                }
            } else {
                cnt = 0;
            }
            third.append(now);
        }
        new_id = third.toString();

        // 4
        if (new_id.length() > 0 && new_id.charAt(0) == '.') {
            new_id = new_id.substring(1);
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 5
        if (new_id.length() == 0) {
            new_id += 'a';
        }

        // 6
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        // 7
        if (new_id.length() <= 2) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while (new_idBuilder.length() < 3) {
                new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
            }
            new_id = new_idBuilder.toString();
        }
        return new_id;
    }

    public static void main(String[] args) throws IOException {
        RecommandNewId recommandNewId = new RecommandNewId();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String abcb = recommandNewId.solution(br.readLine());
        System.out.println(abcb);
    }
}
