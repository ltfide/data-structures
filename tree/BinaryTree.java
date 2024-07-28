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

    static void deleteDeepest(Node root, Node _node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();

            if (temp == _node) {
                temp = null;
                _node = null;
                return;
            }

            if (temp.right != null) {
                if (temp.right == _node) {
                    temp.right = null;
                    _node = null;
                    return;
                } else {
                    queue.offer(temp.right);
                }
            }

            if (temp.left != null) {
                if (temp.left == _node) {
                    temp.left = null;
                    _node = null;
                    return;
                } else {
                    queue.offer(temp.left);
                }
            }
        }
    }

    static Node delete(Node root, int key) {
        if (root == null) return null;
        if (root.left == null & root.right == null) {
            if (root.data == key) {
                return null;
            } else {
                return root;
            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        Node temp = new Node(0);
        Node keyNode = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.data == key) keyNode = temp;
            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }

        if (keyNode != null) {
            keyNode.data = temp.data;
            deleteDeepest(root, temp);
        }

        return root;
    }

    static void inOrderTraversal(Node root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    static void preOrderTraversal(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(Node root) {
        if (root == null) return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + ", ");
    }

    static void levelOrderTraversal(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");

            /* Push left child in the queue */
            if (temp.left != null) {
                queue.offer(temp.left);
            }

            /* Push right child in the queue */
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }


    public static void main(String[] args) {
        Node root = null;
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 60);
        root = insert(root, 30);
        root = insert(root, 11);

        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);

        System.out.println("\nIn Order Traversal");
        inOrderTraversal(root);

        System.out.println("\nPost Order Traversal");
        postOrderTraversal(root);

        System.out.println("\nBefore");
        preOrderTraversal(root);
        delete(root, 20);
        System.out.println("\nAfter");
        preOrderTraversal(root);
    }
}