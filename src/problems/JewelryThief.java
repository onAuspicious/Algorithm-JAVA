package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class JewelryThief {

    static class Jewelry{
        int weight;
        int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        long result = 0;

        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        PriorityQueue<Jewelry> canStole = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);
        int[] bags = new int[k];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            jewelries.offer(new Jewelry(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }

        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        for (int bag : bags) {
            while (!jewelries.isEmpty() && bag >= jewelries.peek().weight) {
                canStole.offer(jewelries.poll());
            }
            if (!canStole.isEmpty()) {
                result += canStole.poll().price;
            }
        }
        System.out.println(result);
    }
}
