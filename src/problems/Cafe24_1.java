package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cafe24_1 {

    public String[] solution(int startNumber, int endNumber) {
        String[] result = new String[Math.abs(startNumber - endNumber) + 1];
        StringBuilder tmp = new StringBuilder();
        int cur = 0;

        if (startNumber < endNumber) {
            for (int i = startNumber; i <= endNumber; i++) {
                StringBuilder sb = new StringBuilder();
                tmp.append(i);
                while (sb.length() + tmp.length() < 10) {
                    sb.append(0);
                }
                sb.append(tmp);
                result[cur++] = sb.toString();
            }
        } else {
            for (int i = startNumber; i >= endNumber; i--) {
                StringBuilder sb = new StringBuilder();
                tmp.append(i);
                while (sb.length() + tmp.length() < 10) {
                    sb.append(0);
                }
                sb.append(tmp);
                result[cur++] = sb.toString();
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Cafe24_1 cafe24_1 = new Cafe24_1();
        String[] solution = cafe24_1.solution(5, 2);
        for (String s : solution) {
            System.out.println(s);
        }
    }
}
