package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ACMHotel {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int height;
        int weight;
        int H;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            height = Integer.parseInt(line[0]);
            weight = Integer.parseInt(line[1]);
            H = Integer.parseInt(line[2]);
            if (H % height == 0) {
                System.out.println(height * 100 + H/height);
            } else {
                System.out.println(H%height * 100 + H/height+1);
            }
        }
    }
}
