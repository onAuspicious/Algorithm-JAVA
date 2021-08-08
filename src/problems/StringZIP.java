package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class StringZIP {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<Character, Integer> result = new LinkedHashMap<>();
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int num = 0;

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                characters.add(input.charAt(i));
                integers.add(num);
                num = 0;
            } else {
                num = num * 10 + input.charAt(i) - '0';
            }
        }
        integers.add(num);
        integers.remove(0);

        char nowChar;
        int nowInt;

        for (int i = 0; i < integers.size(); i ++){
            nowChar = characters.get(i);
            nowInt = integers.get(i);
            if (!result.containsKey(nowChar)) {
                result.put(nowChar, nowInt);
            } else {
                result.replace(nowChar, result.get(nowChar) + nowInt);
            }
        }

        result.forEach((key, value) -> {
            sb.append(key).append(value);
        });

        System.out.println(sb);
    }
}
