package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pitagoras {

    public boolean solution(int s1, int s2, int l) {
        return s1 * s1 + s2 * s2 == l * l;
    }

    public static void main(String[] args) throws IOException {
        Pitagoras main = new Pitagoras();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x; int y; int z;
        boolean result;

        while (true) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("0") && line[1].equals("0") && line[2].equals("0")) {
                break;
            } else {
                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);
                z = Integer.parseInt(line[2]);
                if (x > y && x > z) {
                    result = main.solution(y, z, x);
                } else if (x < y && z < y) {
                    result = main.solution(x, z, y);
                } else {
                    result = main.solution(x, y, z);
                }
                if (result) {
                    System.out.println("right");
                } else {
                    System.out.println("wrong");
                }
            }
        }
    }
}
