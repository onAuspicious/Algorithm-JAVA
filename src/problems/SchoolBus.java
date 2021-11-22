package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class SchoolBus {

    static int n, k, s; // 아파트 단지수, 통학버스의 정원, 학교의 위치

    static class Location implements Comparable<Location>{
        int locate;
        int student;

        public Location(int locate, int student) {
            this.locate = locate;
            this.student = student;
        }


        @Override
        public int compareTo(Location o) {
            return o.locate - this.locate;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        s = Integer.parseInt(input[2]);
        PriorityQueue<Location> leftSide = new PriorityQueue<>();
        PriorityQueue<Location> rightSide = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int dist = Integer.parseInt(input[0]);
            int student = Integer.parseInt(input[1]);
            if (dist < s) {
                leftSide.offer(new Location(s - dist, student));
            } else {
                rightSide.offer(new Location(dist - s, student));
            }
        }

        int result = 0;
        result += busMoveTime(leftSide); // 학교를 기준으로 왼쪽에 있는 단지들
        result += busMoveTime(rightSide); //학교를 기준으로 오른쪽에 있는 단지들
        System.out.println(result);
    }

    // 우선순위 큐의 값은 학교에서 가장 먼 순서대로 높은 우선순위를 가집니다
    // 가장 멀리 있는 단지의 학생들을 태워오며 버스에 빈자리가 있을 경우 다음으로 먼 단지를 탐색해서 버스에 태웁니다
    // 모든 단지의 학생을 태우는 동안의 왕복 거리를 move에 저장해서 반환합니다
    public static int busMoveTime(PriorityQueue<Location> locations) {
        int move = 0;
        while (!locations.isEmpty()) {
            Location now = locations.poll();
            int cnt = now.student / k; // 해당 단지를 왕복하는 횟수
            if (now.student % k > 0) {
                cnt++;
            }
            int rem = k * cnt - now.student; // 데려가고 남은 학생 수
            while (!locations.isEmpty()) {
                Location next = locations.poll();
                if (next.student <= rem) {
                    rem -= next.student;
                } else {
                    next.student -= rem;
                    locations.offer(next);
                    break;
                }
            }
            move += (2 * cnt * now.locate);
        }
        return move;
    }
}
