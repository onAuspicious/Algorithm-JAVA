package programmers;

import java.io.*;

public class AB5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] now = br.readLine().split(" ");
            int x = Integer.parseInt(now[0]);
            int y = Integer.parseInt(now[1]);

            if (x == 0 && y == 0) {
                break;
            } else {
                bw.write(x + y + "\n");
            }
        }
        bw.close();
    }
}
