package problems;

import java.io.*;

public class PrintStars {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N+1; i++) {
            for (int j = 0; j < i; j++) {
                bw.write("*");
            }
            bw.newLine();
        }
        bw.close();
    }
}
