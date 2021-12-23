package problems;

import java.util.*;

public class CandidateKey {

    int rowSize, columnSize;
    int result;
    List<String> keyList;
    HashSet<String> keySet = new HashSet<>();
    boolean state;


    public int solution(String[][] relation) {
        columnSize = relation[0].length;
        rowSize = relation.length;
        result = 0;
        keyList = new ArrayList<>();


        DFS(0, relation, new ArrayDeque<>());


        keyList.sort(new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String key : keyList) {
            state = true;
            minimalityCheck(0, key, new ArrayDeque<>());
            if (state) {
                result++;
                keySet.add(key);
            }
        }

        return result;
    }

    public void minimalityCheck(int level, String key, ArrayDeque<Character> keyPart) {
        if (!state) return;

        if (level == key.length()) {
            if (keyPart.size() == 0) return;
            StringBuilder sb = new StringBuilder();
            for (Character c : keyPart) {
                sb.append(c);
            }

            if (keySet.contains(sb.toString())) {

                state = false;
            }
        } else {
            for (int i = level; i < key.length(); i++) {
                keyPart.offerLast(key.charAt(i));
                minimalityCheck(i + 1, key, keyPart);
                keyPart.removeLast();
                minimalityCheck(i + 1, key, keyPart);
            }
        }
    }

    public void DFS(int level, String[][] relation, ArrayDeque<Integer> combination) {
        // end point
        if (columnSize == level) {
            if (combination.size() == 0) return;

            if (isCandidateKey(combination, relation)) {
                StringBuilder sb = new StringBuilder();
                for (int i : combination) sb.append(i);
                keyList.add(sb.toString());
            }
            return;
        }
        for (int i = level; i < columnSize; i++) {
            combination.offerLast(i);
            DFS(i + 1, relation, combination);
            combination.removeLast();
            DFS(i + 1, relation, combination);
        }
    }

    public boolean isCandidateKey(ArrayDeque<Integer> combination, String[][] relation) {
        HashSet<String> keySet = new HashSet<>();
        for (int i = 0; i < rowSize; i++){
            String key = createKey(combination, relation, i);
            keySet.add(key);
        }
        return keySet.size() == rowSize;
    }

    public String createKey(ArrayDeque<Integer> combination, String[][] relation, int row) {
        StringBuilder sb = new StringBuilder();
        for (int idx : combination) {
            sb.append(relation[row][idx]).append('-');
        }
        return sb.toString();
    }
}
