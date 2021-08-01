package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BigIntAplusB {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        BigInteger A = new BigInteger(line[0]);
        BigInteger B = new BigInteger(line[1]);
        System.out.println(A.add(B).toString());
    }
}
