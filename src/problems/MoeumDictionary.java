package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MoeumDictionary {

    static Stack<Character> stack = new Stack<>();
    static char[] words = new char[]{'A', 'E', 'I', 'O', 'U'};
    static int result;
    static int cnt = 0;

    public static int solution(String word) {
        DFS(word,  word.length());
        return result-1;
    }

    static void DFS(String word, int length) {
        if (stack.size() > 5) {
            return;
        }
        cnt++;
        if (stack.size() == length) {
            StringBuilder sb = new StringBuilder();
            for (Character character : stack) {
                sb.append(character);
            }
            if (sb.toString().equals(word)) {
                result = cnt;
            }
        }
        for (int i = 0; i < 5; i++) {
            stack.add(words[i]);
            DFS(word, length);
            stack.pop();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int solution = solution(s);
        System.out.println(solution);
    }
}
