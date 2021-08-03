package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectorShom {

    public boolean isCorrect(int i) {
        int cnt = 0;
        while (i != 0) {
            if (i % 10 == 6) {
                cnt += 1;
            } else {
                cnt = 0;
            }
            if (cnt == 3) {
                return true;
            }
            i /= 10;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        DirectorShom main = new DirectorShom();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        int i = 665;

        while (cnt < n) {
            i++;
            if (main.isCorrect(i)) {
                cnt++;
            }
        }
        System.out.println(i);
    }
}
