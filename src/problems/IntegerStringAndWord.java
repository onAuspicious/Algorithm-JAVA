package problems;

import java.util.*;

public class IntegerStringAndWord {
    public int solution(String s) {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                result.append(s.charAt(i));
            } else {
                temp.append(s.charAt(i));

                if (Arrays.asList(numbers).contains(temp.toString())) {
                    int index = Arrays.asList(numbers).indexOf(temp.toString());
                    result.append((index));
                    temp = new StringBuilder();
                }
            }
        }

        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        String s = "zero2three45sixseven";
        IntegerStringAndWord integerStringAndWord = new IntegerStringAndWord();
        System.out.println(integerStringAndWord.solution(s));
    }
}
