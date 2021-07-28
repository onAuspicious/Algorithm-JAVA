package programmers;

import java.io.*;

public class AB4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;

        while ((line = br.readLine()) != null) {
            String[] now = line.split(" ");
            int x = Integer.parseInt(now[0]);
            int y = Integer.parseInt(now[1]);

            System.out.println(x+y);
        }
        bw.close();
    }
}
