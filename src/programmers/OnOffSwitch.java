package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnOffSwitch {

    public void man(String[] line, int i) {
        int now = i;
        while (now < line.length) {
            if (line[now].equals("0")) {
                line[now] = "1";
            } else {
                line[now] = "0";
            }
            now += i+1;
        }
    }

    public void woman(String[] line, int i) {
        for (int j = 0; j < i+1; j++) {
            if (i + j >= line.length) {
                break;
            }
            if (line[i - j].equals(line[i + j])) {
                if (line[i - j].equals("0")) {
                    line[i - j] = "1";
                    line[i + j] = "1";
                } else {
                    line[i - j] = "0";
                    line[i + j] = "0";
                }
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        OnOffSwitch main = new OnOffSwitch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] switchs = br.readLine().split(" ");
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < k; i++) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("1")) {
                main.man(switchs, Integer.parseInt(line[1])-1);
            } else {
                main.woman(switchs, Integer.parseInt(line[1])-1);
            }
        }

        for (String i : switchs) {
            cnt++;
            System.out.print(i + " ");
            if (cnt == 20) {
                System.out.println();
                cnt = 0;
            }
        }
    }
}
