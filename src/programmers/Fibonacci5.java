package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci5 {

    public int fibonacci(int i, int[] fibo) {
        if (i < 2) {
            return i;
        }
        if (fibo[i] != 0) {
            return fibo[i];
        }
        fibo[i] = fibonacci(i - 1, fibo) + fibonacci(i - 2, fibo);
        return fibo[i];
    }

    public static void main(String[] args) throws IOException {
        Fibonacci5 main = new Fibonacci5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(br.readLine());
        int[] fibo = new int[i + 1];
        System.out.println(main.fibonacci(i, fibo));
    }
}
