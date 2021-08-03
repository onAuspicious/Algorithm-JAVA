package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CroatiaAlpha {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split("");
        int result = 0;

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("c")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("=")) {
                        i++;
                    } else if (split[i + 1].equals("-")) {
                        i++;
                    }
                }
            } else if (split[i].equals("d")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("z")) {
                        if (i + 2 < split.length) {
                            if (split[i + 2].equals("=")) {
                                i += 2;
                            }
                        }
                    } else if (split[i + 1].equals("-")) {
                        i++;
                    }
                }
            } else if (split[i].equals("l")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("j")) {
                        i++;
                    }
                }
            } else if (split[i].equals("n")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("j")) {
                        i++;
                    }
                }
            } else if (split[i].equals("s")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("=")) {
                        i++;
                    }
                }
            } else if (split[i].equals("z")) {
                if (i + 1 < split.length) {
                    if (split[i + 1].equals("=")) {
                        i++;
                    }
                }
            }
            result++;
        }
        System.out.println(result);
    }
}
