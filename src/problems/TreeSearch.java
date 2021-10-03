package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TreeSearch {

    static HashMap<String, Node> tree = new HashMap<>();
    static StringBuilder pre = new StringBuilder();
    static StringBuilder post = new StringBuilder();
    static StringBuilder in = new StringBuilder();

    static class Node {
        String leftChild;
        String rightChild;

        public Node(String leftChild, String rightChild) {
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            tree.put(split[0], new Node(split[1], split[2]));
        }
        search("A");
        System.out.println(pre);
        System.out.println(post);
        System.out.println(in);
    }

    public static void search(String node) {
        if (!node.equals(".")) {
            Node now = tree.get(node);
            pre.append(node);
            search(now.leftChild);
            post.append(node);
            search(now.rightChild);
            in.append(node);
        }
    }
}
