import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth-First Search (BFS)
 * Author: Lutfi
 * Date  : 11-08-2024 20:56 
 */
public class BFS {
    
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    static void bfsTrsvl(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print(curr.value + " "); // Visit node

            // Add left child to the queue
            if (curr.left != null) queue.add(curr.left); 

            // Add right child to the queue
            if (curr.right != null) queue.add(curr.right);
        }
    }

    static Node sample() {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.left.left.left = new Node(8);
        node.left.left.right = new Node(9);
        return node;
    }

    public static void main(String[] args) {
        Node node = sample();
        bfsTrsvl(node); // 1 2 3 4 5 6 7 8 9
    }
}
