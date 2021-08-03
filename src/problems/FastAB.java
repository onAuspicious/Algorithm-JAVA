package problems;

import java.io.*;

/**
 * BufferedReader, BufferedWriter 를 사용하는 문제
 */
public class FastAB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] now = br.readLine().split(" ");
            bw.write(Integer.parseInt(now[0]) + Integer.parseInt(now[1]) + "\n");
        }
        bw.close();
    }
}
