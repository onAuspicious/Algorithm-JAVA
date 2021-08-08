package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Stack;

public class CrossBridge {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> friends = new Stack<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            friends.add(Integer.parseInt(br.readLine()));
        }
        friends.sort(Comparator.naturalOrder());

        while (!friends.isEmpty()) {
            if (friends.size() > 3) {
                // 제일 빠른 친구가 두번 왔다갔다 하는 경우가 더 빠를 때
                if (friends.get(0) + friends.get(friends.size() - 2) < friends.get(1) * 2) {
                    result += 2 * friends.get(0) + friends.pop() + friends.pop();
                } else {
                    // 두 번째로 빠른 친구가 먼저 가는 경우
                    result += 2 * friends.get(1) + friends.get(0) + friends.pop();
                    friends.pop();
                }
            } else {
                if (friends.size() == 3) {
                    result += friends.pop() + friends.pop() + friends.pop();
                } else if (friends.size() == 2) {
                    result += friends.pop();
                    friends.pop();
                } else {
                    result += friends.pop();
                }
            }
        }
        System.out.println(result);
    }
}
