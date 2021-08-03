package problems;

import java.io.*;

public class LowerThenX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NX = br.readLine().split(" ");
        int N = Integer.parseInt(NX[0]);
        int X = Integer.parseInt(NX[1]);
        String[] list = br.readLine().split(" ");
        for (String s : list) {
            if (Integer.parseInt(s) < X) {
                bw.write(s + " ");
            }
        }
        bw.close();
    }
}
