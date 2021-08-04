package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class SortInside {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> sorted = Arrays.stream(br.readLine().split("")).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Character.compare(o2.charAt(0), o1.charAt(0));
            }
        });
        sorted.iterator().forEachRemaining(System.out::print);
    }
}
