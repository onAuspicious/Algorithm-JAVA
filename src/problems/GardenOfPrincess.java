package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class GardenOfPrincess {

    public static final int END_MONTH = 11;
    public static final int END_DAY = 30;

    static class Flower implements Comparable<Flower>{
        int startMonth;
        int startDay;
        int endMonth;
        int endDay;

        @Override
        public int compareTo(Flower flower) {
            if (this.startMonth * 100 + this.startDay == flower.startMonth * 100 + flower.startDay) {
                return this.endMonth * 100 + this.endDay - (flower.endMonth * 100 - this.endDay);
            }
            return this.startMonth * 100 + this.startDay - (flower.startMonth * 100 + flower.startDay);
        }

        public Flower(int startMonth, int startDay, int endMonth, int endDay) {
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Flower> flowerPriorityQueue = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            flowerPriorityQueue.add(new Flower(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3])));
        }

        int nowMonth = 3;
        int nowDay = 1;
        int count = 0;
        PriorityQueue<Flower> reverse = new PriorityQueue<>((o1, o2) -> o2.endMonth * 100 + o2.endDay - (o1.endMonth * 100 + o1.endDay));

        while (!flowerPriorityQueue.isEmpty()) {
            Flower flower = flowerPriorityQueue.poll();
            if (flower.startMonth * 100 + flower.startDay <= nowMonth * 100 + nowDay) {
                reverse.offer(flower);
            } else {
                if (reverse.isEmpty()) {
                    count = 0;
                    break;
                }
                Flower mostLongFlower = reverse.poll();
                nowMonth = mostLongFlower.endMonth;
                nowDay = mostLongFlower.endDay;
                count++;
                reverse.clear();

                if (END_MONTH * 100 + END_DAY < nowMonth * 100 + nowDay) {
                    break;
                }
                if (flower.startMonth * 100 + flower.startDay <= nowMonth * 100 + nowDay) {
                    reverse.offer(flower);
                }
            }
        }

        if (reverse.isEmpty()) {
            if (END_MONTH * 100 + END_DAY < nowMonth * 100 + nowDay) {
                System.out.println(count);
            } else {
                System.out.println(0);
            }
        } else {
            Flower flower = reverse.poll();
            if (END_MONTH * 100 + END_DAY < flower.endMonth * 100 + flower.endDay) {
                System.out.println(count + 1);
            } else {
                System.out.println(0);
            }
        }
    }
}
