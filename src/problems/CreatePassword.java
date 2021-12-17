package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class CreatePassword {

    static int l, c;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        l = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        String[] alphas = br.readLine().split(" ");
        Arrays.sort(alphas);

        createPassword(0, new ArrayDeque<>(), alphas);
        System.out.println(result);
        br.close();
    }

    public static void createPassword(int level, ArrayDeque<String> password, String[] alphas) {
        if (l == password.size()) {
            if (checkPassword(password)) {
                result.append(toString(password)).append('\n');
            }
            return;
        }

        for (int i = level; i < c; i++) {
            password.offerLast(alphas[i]);
            createPassword(i + 1, password, alphas);
            password.removeLast();
        }
    }

    public static boolean checkPassword(ArrayDeque<String> password) {
        int constant = 0, vowel = 0;
        for (String now : password) {
            if (now.equals("a") || now.equals("e") || now.equals("i") || now.equals("o") || now.equals("u")) {
                vowel++;
            } else {
                constant++;
            }
        }
        return (vowel >= 1 && constant >= 2);
    }

    public static String toString(ArrayDeque<String> password) {
        StringBuilder sb = new StringBuilder();
        for (String s : password) {
            sb.append(s);
        }
        return sb.toString();
    }
}
