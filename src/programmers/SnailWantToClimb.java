package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SnailWantToClimb {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        int V = Integer.parseInt(line[2]);

        if ((V - A) % (A - B) == 0) {
            System.out.println((V - A) / (A - B) + 1);
        } else {
            System.out.println((V - A) / (A - B) + 2);
        }
    }
}
