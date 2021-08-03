package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GroupWordChecker {

    HashMap<String, Boolean> memo = new HashMap<>();

    public boolean solution(String[] word) {
        memo.clear();
        memo.put(word[0], true);
        String now = word[0];

        for (int i = 1; i < word.length; i++) {
            if (!now.equals(word[i])) {
                if (memo.containsKey(word[i])) {
                    return false;
                } else {
                    memo.put(word[i], true);
                }
                now = word[i];
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        GroupWordChecker main = new GroupWordChecker();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;


        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            if (main.solution(split)) {
                result += 1;
            }
        }
        System.out.println(result);
    }
}
