package programmers;

import java.io.*;

public class AB8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] now = br.readLine().split(" ");
            int num = i + 1;
            int result = Integer.parseInt(now[0]) + Integer.parseInt(now[1]);
            bw.write("Case #" + num + ": "+ Integer.parseInt(now[0]) + " + "+ Integer.parseInt(now[1]) + " = " + result + "\n");
        }
        bw.close();
    }
}