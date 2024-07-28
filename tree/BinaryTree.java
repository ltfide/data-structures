import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BinaryTree {
    
    static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node temp = q.poll();

            /* Insert node as the left of the parent node */
            if (temp.left == null) {
                temp.left = new Node(data);
                break;
            } else {
                /* If the left child is not null push it to the queue */
                q.offer(temp.left);
            }

            /* Insert node as the right of the parent node */
            if (temp.right == null) {
                temp.right = new Node(data);
                break;
            } else {
                /* If the right child is not null push it to the queue */
                q.offer(temp.right);
            }
        }

        return root;
    }

    static void preorderTraversal(Node root) {
        if (root == null) return;
        System.out.println("Data: " + root.data);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 30);
        root = insert(root, 11);

        preorderTraversal(root);
    }
}