package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SangSoo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] list = br.readLine().split(" ");

        StringBuilder first = new StringBuilder(list[0]);
        StringBuilder second = new StringBuilder(list[1]);
        int f = Integer.parseInt(first.reverse().toString());
        int s = Integer.parseInt(second.reverse().toString());
        System.out.println(Math.max(f,s));
    }
}
