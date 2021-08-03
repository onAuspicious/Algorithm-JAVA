package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaxiCapGeometry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double i = Double.parseDouble(br.readLine());

        System.out.println(Math.pow(i, 2) * Math.PI);
        System.out.println(Math.pow(2*i, 2) / 2);
    }
}
