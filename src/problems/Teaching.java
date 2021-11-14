package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Teaching {

    static int n, k, result = 0;
    static HashSet<Character> learned = new HashSet<>();
    static HashSet<Character>[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        char[] need = new char[]{'n', 'a', 't', 'i', 'c'};
        words = new HashSet[n];

        for (int i = 0; i < n; i++) {
            words[i] = new HashSet<>();
        }

        if (k <= 4) {
            System.out.println(0);
            System.exit(0);
        }
        for (int i = 0; i < 5; i++) {
            learned.add(need[i]);
        }
        k -= 5;

        for (int i = 0; i < n; i++) {
            String sentence = br.readLine();
            for (int j = 0; j < sentence.length(); j++) {
                words[i].add(sentence.charAt(j));
            }
        }

        searchLearn(0);

        System.out.println(result);
    }

    public static void searchLearn(int level) {
        if (k == 0) {
            result = Math.max(result, countLearnableWords());
            return;
        }
        for (int i = level; i < 26; i++) {
            char now = (char) (97 + i);
            if (!learned.contains(now)){
                k--;
                learned.add(now);
                searchLearn(i + 1);
                learned.remove(now);
                k++;
            }
        }
    }

    public static int countLearnableWords() {
        int cnt = 0;
        boolean state;
        for (HashSet<Character> word : words) {
            state = true;
            for (Character character : word) {
                if (!learned.contains(character)) {
                    state = false;
                    break;
                }
            }
            if (state) cnt++;
        }
        return cnt;
    }
}
