package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Turret {

    double x1; double y1; double r1;
    double x2; double y2; double r2;

    public int solution(String[] line) {
        x1 = Double.parseDouble(line[0]);
        y1 = Double.parseDouble(line[1]);
        r1 = Double.parseDouble(line[2]);
        x2 = Double.parseDouble(line[3]);
        y2 = Double.parseDouble(line[4]);
        r2 = Double.parseDouble(line[5]);
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        double distance = Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
        if (r1 + r2 < distance) {
            return 0;
        } else if (r1 + r2 == distance) {
            return 1;
        } else {
            if (Math.abs(r1-r2) > distance) {
                return 0;
            } else if (Math.abs(r1 - r2) == distance) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Turret main = new Turret();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            System.out.println(main.solution(line));
        }
    }
}
