package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplosion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String explosion = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if (stack.size() >= explosion.length()) {
                boolean breakPoint = true;
                for (int j = 0; j < explosion.length(); j++) {
                    if (stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
                        breakPoint = false;
                        break;
                    }
                }
                if (breakPoint) {
                    for (int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : stack) {
            stringBuilder.append(character);
        }

        System.out.println(stringBuilder.length() > 0 ? stringBuilder.toString() : "FRULA");
    }
}
