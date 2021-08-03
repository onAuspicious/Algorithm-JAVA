package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FourthPoint {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> front = new ArrayList<>();
        ArrayList<String> end = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] point = br.readLine().split(" ");
            if (front.contains(point[0])) {
                front.remove(point[0]);
            } else {
                front.add(point[0]);
            }
            if (end.contains(point[1])) {
                end.remove(point[1]);
            } else {
                end.add(point[1]);
            }
        }
        System.out.println(front.get(0) + " " + end.get(0));
    }
}
