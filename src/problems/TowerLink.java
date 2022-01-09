package problems;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TowerLink {

    static class Tower implements Comparable<Tower>{
        int locate;
        int height;

        public Tower(int locate, int height) {
            this.locate = locate;
            this.height = height;
        }

        @Override
        public int compareTo(Tower o) {
            return this.locate - o.locate;
        }
    }

    public int solution(int[][] tower, int k) {
        HashMap<Integer, PriorityQueue<Tower>> towerMap = new HashMap<>();
        int result = 0;

        for (int i = 0; i < tower.length; i++) {
            if (!towerMap.containsKey(tower[i][1])) {
                towerMap.put(tower[i][1], new PriorityQueue<>());
            }
            PriorityQueue<Tower> pq = towerMap.get(tower[i][1]);
            pq.offer(new Tower(tower[i][0], tower[i][1]));
        }

        for (int towerHeight : towerMap.keySet()) {
            int group = 1;
            int now = -1;
            PriorityQueue<Tower> towers = towerMap.get(towerHeight);

            while (!towers.isEmpty()) {
                Tower t = towers.poll();
                if (now == -1) now = t.locate;
                if (t.locate > now + k) {
                    group++;
                }
                now = t.locate;
            }
            result += group;
        }

        return result;
    }
}
