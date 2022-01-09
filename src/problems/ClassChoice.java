package problems;

public class ClassChoice {

    String[] dates = new String[]{"MO", "TU", "WE", "TH", "FR"};
    int result;

    static class Class {
        int date;
        int startTime;
        int endTime;

        public Class(int date, int startTime, int endTime) {
            this.date = date;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public int solution(String[][] schedule) {
        Class[][][] classes = new Class[5][4][2]; // 0 : MO ~ 5 : FR

        // classes init
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                String[] now = schedule[i][j].split(" ");
                // 1 : 30 씩 나눠서 수업하는 경우와 3시간 연달아 수업하는 경우를 나눈다
                if (now.length > 2) {
                    Class c1 = makeClass(now[0], now[1].split(":"), 9);
                    Class c2 = makeClass(now[2], now[3].split(":"), 9);
                    classes[i][j][0] = c1;
                    classes[i][j][1] = c2;
                } else {
                    Class c = makeClass(now[0], now[1].split(":"), 18);
                    classes[i][j][0] = c;
                }
            }
        }

        result = 0;
        boolean[][] timeTable = new boolean[5][1000];
        DFS(0, classes, timeTable);

        return result;
    }

    public void DFS(int lecture, Class[][][] classes, boolean[][] timeTable) {
        if (lecture == 5) {
            result++;
            return;
        }
        for (Class[] lectures : classes[lecture]) {
            // 3시간 연속 수업의 경우
            if (lectures[1] == null) {
                if (checkLecture(lectures[0], timeTable)) {
                    addLecture(lectures[0], timeTable);
                    DFS(lecture + 1, classes, timeTable);
                    removeLecture(lectures[0], timeTable);
                }
            } else {
                // 1:30 분씩 나누는 수업
                if (checkLecture(lectures[0], timeTable) && checkLecture(lectures[1], timeTable)) {
                    addLecture(lectures[0], timeTable);
                    addLecture(lectures[1], timeTable);
                    DFS(lecture + 1, classes, timeTable);
                    removeLecture(lectures[0], timeTable);
                    removeLecture(lectures[1], timeTable);
                }
            }
        }
    }

    // timeTable 에서 class 를 추가하는 함수
    public void addLecture(Class c, boolean[][] timeTable) {
        for (int i = c.startTime; i <= c.endTime; i++) {
            timeTable[c.date][i] = true;
        }
    }

    // timeTable 에 class를 제거하는 함수
    public void removeLecture(Class c, boolean[][] timeTable) {
        for (int i = c.startTime; i <= c.endTime; i++) {
            timeTable[c.date][i] = false;
        }
    }

    // 해당 시간에 강의를 들을 수 있는지 판단하는 함수
    public boolean checkLecture(Class c, boolean[][] timeTable) {
        int cnt = 0;
        for (int i = c.startTime + 1; i < c.endTime; i++) {
            if (timeTable[c.date][i]) cnt++;
        }
        return cnt < 1;
    }

    // Class 생성 함수
    public Class makeClass(String date, String[] time, int min) {
        int startTime = ((Integer.parseInt(time[0]) - 9) * 6) + Integer.parseInt(time[1]) / 10;
        int endTime = startTime + min;
        return new Class(findDateToInt(date), startTime, endTime);
    }

    // MO ~ FR 을 0 ~ 5로 변환 후 반환하는 함수
    public int findDateToInt(String date) {
        int d = 0;
        for (int i = 0; i < 5; i++) {
            if (date.equals(dates[i])) {
                d = i;
                break;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        ClassChoice kakao3 = new ClassChoice();
        int solution = kakao3.solution(new String[][]{{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
                {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
                {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
                {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}});
        System.out.println(solution);
    }
}
