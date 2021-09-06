package problems;

import java.util.Arrays;
import java.util.Comparator;

public class BoxerSort {
    static int num;

    static class Boxer{
        int number;
        double weight;
        double win;
        double bigwin;
        double rate;

        public Boxer(int number, double weight, double win, double bigwin, double rate) {
            this.number = number;
            this.weight = weight;
            this.win = win;
            this.bigwin = bigwin;
            this.rate = rate;
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        num = weights.length;
        Boxer[] boxers = new Boxer[num];
        double win;
        double rate;
        double cnt;
        int rateCnt;
        int[] result = new int[num];

        for (int i = 0; i < num; i++) {
            win = 0;
            cnt = 0;
            rateCnt = 0;
            for (int j = 0; j < num; j++) {
                if (head2head[i].charAt(j) != 'N') {
                    rateCnt++;
                    if (head2head[i].charAt(j) == 'W') {
                        win++;
                        if (weights[i] < weights[j]) {
                            cnt++;
                        }
                    }
                }
            }
            if (win == 0) {
                rate = 0;
            } else {
                rate = win / rateCnt;
            }
            System.out.println(rate);
            Boxer boxer = new Boxer(i+1, weights[i], win, cnt, rate);
            boxers[i] = boxer;
        }

        Arrays.sort(boxers, new Comparator<Boxer>() {
            @Override
            public int compare(Boxer o1, Boxer o2) {
                if (o1.rate > o2.rate) {
                    return -1;
                } else if (o1.rate < o2.rate) {
                    return 1;
                } else {
                    if (o1.bigwin > o2.bigwin) {
                        return -1;
                    } else if (o1.bigwin < o2.bigwin) {
                        return 1;
                    } else {
                        if (o1.weight > o2.weight) {
                            return -1;
                        } else if (o1.weight < o2.weight) {
                            return 1;
                        } else {
                            return o1.number - o2.number;
                        }
                    }
                }
            }
        });
        for (int i = 0; i < num; i++) {
            result[i] = boxers[i].number;
        }
        return result;
    }
}
