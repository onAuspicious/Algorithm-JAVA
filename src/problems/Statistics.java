package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Statistics {

    public int average(List<Double> list) {
        double result = 0;
        for (Double i : list) {
            result += i;
        }
        return (int) Math.round(result / list.size());
    }

    public int mostValue(HashMap<Double, Integer> memo,  int maximum) {
        ArrayList<Double> result = new ArrayList<>();
        for (Double i : memo.keySet()) {
            if (memo.get(i) == maximum) {
                result.add(i);
            }
        }
        Collections.sort(result);
        if (result.size() > 1) {
            return result.get(1).intValue();
        } else {
            return result.get(0).intValue();
        }
    }

    public static void main(String[] args) throws IOException {
        Statistics main = new Statistics();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        double tmp;
        int maximum = 0;
        ArrayList<Double> list = new ArrayList<>();
        HashMap<Double, Integer> memo = new HashMap<>();

        for (int i = 0; i < n; i++) {
            tmp= Double.parseDouble(br.readLine());
            list.add(tmp);
            if (memo.containsKey(tmp)) {
                memo.replace(tmp, memo.get(tmp) + 1);
            } else {
                memo.put(tmp, 1);
            }
            if (maximum < memo.get(tmp)) {
                maximum = memo.get(tmp);
            }
        }

        Collections.sort(list);
        System.out.println(main.average(list));
        System.out.println(list.get(list.size()/2).intValue());
        System.out.println(main.mostValue(memo, maximum));
        System.out.println((int)(list.get(list.size()-1) - list.get(0)));
    }
}
