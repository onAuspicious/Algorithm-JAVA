package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Lost_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Character> characters = new ArrayList<>();

        int num = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                num = num * 10 + input.charAt(i) - '0';
            } else {
                numbers.add(num);
                num = 0;
                characters.add(input.charAt(i));
            }
        }

        numbers.add(num);

        boolean state = true;
        int result = numbers.get(0);

        for (int i = 0; i < characters.size(); i++) {
            if (state && characters.get(i) == '+') {
                result += numbers.get(i+1);
            } else {
                state = false;
                result -= numbers.get(i+1);
            }
        }

        System.out.println(result);
    }
}
