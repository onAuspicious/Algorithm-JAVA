package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        HashMap<String, Integer> keyByName = new HashMap<>();
        HashMap<Integer, String> keyByNum = new HashMap<>();

        for (int i = 1; i < n + 1; i++) {
            String poketmon = br.readLine();
            keyByNum.put(i, poketmon);
            keyByName.put(poketmon, i);
        }

        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            if (Character.isDigit(question.charAt(0))) {
                result.append(keyByNum.get(Integer.parseInt(question))).append('\n');
            } else {
                result.append(keyByName.get(question)).append('\n');
            }
        }
        System.out.println(result);
    }
}
