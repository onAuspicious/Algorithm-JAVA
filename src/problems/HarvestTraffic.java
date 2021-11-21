package problems;

import java.util.*;

public class HarvestTraffic {

    static class Time implements Comparable<Time>{
        double completeTime;
        double inputTime;

        public Time(double completeTime, double inputTime) {
            this.completeTime = completeTime;
            this.inputTime = inputTime;
        }

        @Override
        public int compareTo(Time time) {
            if (this.completeTime < time.completeTime) {
                return -1;
            } else if (this.completeTime > time.completeTime) {
                return 1;
            } else {
                return  (int) (this.inputTime - time.inputTime);
            }
        }
    }

    public int solution(String[] lines) {
        int result = 0;
        ArrayDeque<Time> times = new ArrayDeque<>();
        Time[] logs = new Time[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String[] info = lines[i].split(" ");
            double completeTime = returnCompleteTime(info[1]);
            double inputTime = completeTime - returnExecuteTime(info[2]);
            Time time = new Time(Math.floor(completeTime * 1000 + 999) / 1000.0, Math.floor(inputTime * 1000 + 1) / 1000.0);
            logs[i] = time;
        }

        Arrays.sort(logs);

        for (int i = 0; i < logs.length; i++) {
            int cnt = 1;
            Time now = logs[i];
            for (int j = i+1; j < logs.length; j++) {
                Time next = logs[j];
                if (now.completeTime >= next.inputTime) cnt++;
            }
            result = Math.max(result, cnt);
        }

        return result;
    }

    public double returnCompleteTime(String time) {
        String[] split = time.split(":");
        double hour = Double.parseDouble(split[0]) * 60 * 60;
        double minute = Double.parseDouble(split[1]) * 60;
        double second = Double.parseDouble(split[2]);
        return hour + minute + second;
    }

    public double returnExecuteTime(String time) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < time.length() - 1; i++) {
            sb.append(time.charAt(i));
        }
        return Double.parseDouble(sb.toString());
    }
}
