/**
 * Depth-First Search (DFS)
 */
public class DFS {

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

    /**
     * Inorder Traversal
     * Left - Root - Right
     */
    static void inorderTrvsl(Node root) {
        if (root == null) return;
        inorderTrvsl(root.left); // visit left subtree
        System.out.print(root.value + " "); // visit root
        inorderTrvsl(root.right); // visit right subtree
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

    static void inorderTrvslPrint() {
        /* Example
                1
             /      \
            2        3
           /  \     /  \
          4    5   6    7
         /      \
        8        9
       /          \
      10          11
       */
       
        System.out.println("Inorder Traversal");
        Node node = sample();
        node.left.left.left.left = new Node(10);
        node.left.left.left.right = new Node(11);
        inorderTrvsl(node); // 10 8 11 4 9 2 5 1 6 3 7
    }


    /**
     * Preorder Traversal
     * Root - Left - Right
     */
    static void preorderTrsvl(Node root) {
        if (root == null) return;
        System.out.print(root.value + " "); // Visit root 
        preorderTrsvl(root.left); // Visit left substree
        preorderTrsvl(root.right); // Visit right substree
    }

    static void preorderTrsvlPrint() {
        /* Example
                1
             /      \
            2        3
           /  \     /  \
          4    5   6    7
         /      \
        8        9 */

        System.out.println("\nPreorder Traversal");
        Node node = sample();
        preorderTrsvl(node); // 1 2 4 8 9 5 3 6 7
    }

    static void postorderTrsvl(Node root) {
        if (root == null) return;
        postorderTrsvl(root.left); // Visit left subtree
        postorderTrsvl(root.right); // Visit right subtree
        System.out.print(root.value  + " "); // Visit root
    }

    static void postorderTrsvlPrint() {
        /* Example
                1
             /      \
            2        3
           /  \     /  \
          4    5   6    7
         /      \
        8        9 */

        System.out.println("\nPostorder Traversal");
        Node node = sample();
        preorderTrsvl(node); // 1 2 4 8 9 5 3 6 7
    }

    public static void main(String[] args) {
        inorderTrvslPrint();
        preorderTrsvlPrint();
        postorderTrsvlPrint();
    }
}