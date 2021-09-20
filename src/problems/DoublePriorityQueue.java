package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

public class DoublePriorityQueue {

    static PriorityQueue<Integer> max = new PriorityQueue<>();
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    static HashMap<Integer, Integer> removedFromMax = new HashMap<>();
    static HashMap<Integer, Integer> removedFromMin = new HashMap<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int now;
    static int poll;

    static StringBuilder sb= new StringBuilder();

    public static void solution(int input) throws IOException {
        for (int i = 0; i < input; i++) {
            String[] split = br.readLine().split(" ");
            now = Integer.parseInt(split[1]);
            if (split[0].equals("I")) {
                min.add(now);
                max.add(-now);
            } else {
                //remove from min
                if (now == -1 && !min.isEmpty()) {
                    poll = min.poll();
                    if (removedFromMin.containsKey(poll)) {
                        removedFromMin.replace(poll, removedFromMin.get(poll) + 1);
                    } else {
                        removedFromMin.put(poll, 1);
                    }
                } else if (now == 1 && !max.isEmpty()) { //remove from max
                    poll = -max.poll();
                    if (removedFromMax.containsKey(poll)) {
                        removedFromMax.replace(poll, removedFromMax.get(poll) + 1);
                    } else {
                        removedFromMax.put(poll, 1);
                    }
                }
                while (!min.isEmpty() && removedFromMax.containsKey(min.peek())) {
                    poll = min.poll();
                    if (removedFromMax.get(poll) == 1) {
                        removedFromMax.remove(poll);
                    } else {
                        removedFromMax.replace(poll, removedFromMax.get(poll) - 1);
                    }
                }
                while (!max.isEmpty() && removedFromMin.containsKey(-max.peek())) {
                    poll = -max.poll();
                    if (removedFromMin.get(poll) == 1) {
                        removedFromMin.remove(poll);
                    } else {
                        removedFromMin.replace(poll, removedFromMin.get(poll) - 1);
                    }
                }
            }
        }
        if (!max.isEmpty() && !min.isEmpty()) {
            sb.append(-max.peek()).append(' ').append(min.peek()).append('\n');
        } else {
            sb.append("EMPTY").append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            int input = Integer.parseInt(br.readLine());
            max.clear();
            min.clear();
            removedFromMax.clear();
            removedFromMin.clear();
            solution(input);
        }
        System.out.println(sb);
    }
}
