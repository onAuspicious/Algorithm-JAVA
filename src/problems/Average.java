package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Average {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Double max = 0D;
        double result = 0D;
        String[] points = br.readLine().split(" ");
        Double[] dPoints = new Double[points.length];

        for (int i = 0; i < points.length; i++) {
            dPoints[i] = Double.parseDouble(points[i]);
            if (max < dPoints[i]) max = dPoints[i];
        }

        for (Double dPoint : dPoints) {
            result += dPoint / max * 100;
        }
        System.out.println(result/N);
    }
}
