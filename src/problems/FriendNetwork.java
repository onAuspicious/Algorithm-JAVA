package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FriendNetwork {

    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            index = -1;
            networking(sb, br);
        }

        System.out.println(sb);
        br.close();
    }

    public static void networking(StringBuilder sb, BufferedReader br) throws IOException {
        int f = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> networkMemNumberMap = new HashMap<>(); // 네트워크 내부의 인원들을 담은 맵
        HashMap<String, Integer> nameIndexMap = new HashMap<>(); // 이름 to 배열 index
        int[] disjointSet = new int[f * 2];

        // disjointSet init
        for (int i = 0; i < f * 2; i++) {
            disjointSet[i] = i;
            networkMemNumberMap.put(i, 1);
        }

        for (int i = 0; i < f; i++) {
            String[] input = br.readLine().split(" ");
            int index1 = inputNameIndexMap(nameIndexMap, input[0]);
            int index2 = inputNameIndexMap(nameIndexMap, input[1]);

            sb.append(union(index1, index2, disjointSet, networkMemNumberMap)).append('\n');
        }
    }

    public static int union(int i1, int i2, int[] disjointSet, Map<Integer, Integer> networkMemNumberMap) {
        i1 = find(i1, disjointSet);
        i2 = find(i2, disjointSet);

        if (i1 != i2) {
            int parent = Math.min(i1, i2);
            int child = Math.max(i1, i2);
            disjointSet[child] = parent;
            networkMemNumberMap.put(parent, networkMemNumberMap.get(parent) + networkMemNumberMap.get(child));
            networkMemNumberMap.remove(child);
            return networkMemNumberMap.get(parent);
        }
        return networkMemNumberMap.get(i1);
    }

    public static int find(int start, int[] disjointSet) {
        if (disjointSet[start] != start) {
            return disjointSet[start] = find(disjointSet[start], disjointSet);
        }
        return start;
    }

    public static int inputNameIndexMap(Map<String, Integer> map, String name) {
        if (!map.containsKey(name)) {
            map.put(name, ++index);
        }
        return map.get(name);
    }
}
