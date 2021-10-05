package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeSearch_2263 {

    static StringBuilder sb = new StringBuilder();
    static int[] inorder;
    static int[] postorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inorder = new int[n];
        postorder = new int[n];
        String[] io = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(io[i]);
        }

        String[] po = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(po[i]);
        }
        preorder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    public static void preorder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            sb.append(postorder[pe]).append(" ");

            int pos = is;
            for (int i = is; i < ie; i++) {
                if (inorder[i] == postorder[pe]) {
                    pos = i;
                    break;
                }
            }

            preorder(is, pos - 1, ps, ps + pos - is - 1);
            preorder(pos + 1, ie, ps + pos - is, pe - 1);

        }
    }
}
