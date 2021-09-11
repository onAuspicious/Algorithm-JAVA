package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Parking {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map_in = new HashMap<>();
        Map<String, Integer> park_time = new HashMap<>();
        Map<String, Integer> map_car = new TreeMap<>();

        // save data
        for (String record : records) {
            String[] split = record.split(" ");
            int time = createTime(split[0]);
            if (split[2].equals("IN")) {
                map_in.put(split[1], time);
            } else {
                if (!park_time.containsKey(split[1])) {
                    park_time.put(split[1], time - map_in.get(split[1]));
                } else {
                    park_time.replace(split[1], park_time.get(split[1]) + time - map_in.get(split[1]));
                }
                map_in.remove(split[1]);
            }
        }

        for (String key : map_in.keySet()) {
            if (!park_time.containsKey(key)) {
                park_time.put(key, 1439 - map_in.get(key));
            } else {
                park_time.replace(key, park_time.get(key) + 1439 - map_in.get(key));
            }
        }

        // calc result
        for (String key : park_time.keySet()) {
            if (park_time.get(key) <= fees[0]) {
                map_car.put(key, fees[1]);
            } else {
                map_car.put(key, fees[1] + (int) Math.ceil((double) (park_time.get(key) - fees[0]) / fees[2]) * fees[3]);
            }
        }

        int i = 0;
        int[] result = new int[map_car.keySet().size()];
        for (String key : map_car.keySet()) {
            result[i] = map_car.get(key);
            i++;
        }

        return result;
    }

    public int createTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        Parking parking = new Parking();
        int[] solution = parking.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        for (int i : solution) {
            System.out.println(i);
        }
    }
}
