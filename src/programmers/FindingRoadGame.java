package programmers;

import java.util.*;

class Node {
    Integer number;
    Integer x;
    Integer y;

    Node parent;
    Node leftChild;
    Node rightChild;

    public Node( Integer x, Integer y, Integer number) {
        this.number = number;
        this.x = x;
        this.y = y;
    }

    public void insertChild(Node now) {
        if (now.x < x) {
            if (leftChild == null) {
                leftChild = now;
                now.parent = this;
            } else {
                leftChild.insertChild(now);
            }
        } else {
            if (rightChild == null) {
                rightChild = now;
                now.parent = this;
            } else {
                rightChild.insertChild(now);
            }
        }

    }
}

public class FindingRoadGame {
    ArrayList<Integer> resultOfPreorder = new ArrayList<>();
    ArrayList<Integer> resultOfPostorder = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        Integer[][] nodes = new Integer[nodeinfo.length][3];
        int[][] result = new int[2][nodes.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i][0] = nodeinfo[i][0];
            nodes[i][1] = nodeinfo[i][1];
            nodes[i][2] = i + 1;
        }

        Arrays.sort(nodes, (a, b) -> {
            if (a[1].equals(b[1])) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        Node start = new Node(nodes[0][0], nodes[0][1], nodes[0][2]);

        for (int i = 1; i < nodes.length; i++) {
            Node now = new Node(nodes[i][0], nodes[i][1], nodes[i][2]);
            start.insertChild(now);
        }

        preOrder(start, resultOfPreorder);
        postOrder(start, resultOfPostorder);

        for (int i = 0; i < resultOfPostorder.size(); i++) {
            result[0][i] = resultOfPreorder.get(i);
            result[1][i] = resultOfPostorder.get(i);
        }
        return result;
    }

    public void preOrder(Node node, ArrayList<Integer> memo) {
        memo.add(node.number);
        if (node.leftChild != null) {
            preOrder(node.leftChild, memo);
        }
        if (node.rightChild != null) {
            preOrder(node.rightChild, memo);
        }
    }

    public void postOrder(Node node, ArrayList<Integer> memo) {
        if (node.leftChild != null) {
            postOrder(node.leftChild, memo);
        }
        if (node.rightChild != null) {
            postOrder(node.rightChild, memo);
        }
        memo.add(node.number);
    }

    public static void main(String[] args) {
        int[][] nodeinfo = new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        FindingRoadGame findingRoadGame = new FindingRoadGame();
        int[][] solution = findingRoadGame.solution(nodeinfo);
        for (int[] ints : solution) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
