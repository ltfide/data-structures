class Node {
    int value;
    Node left, right;

    Node(int item) {
        value = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int value) {
        root = insertRec(root, value);
    }

    Node insertRec(Node root, int value) {
        /* if the tree is empty, return a new node */
        if (root == null) {
            root = new Node(value);
            return root;
        }

        /* recur down the tree */
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        /* return the (unchange) node pointer */
        return root;
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

         /* Let us create following BST
              50
           /      \
          30       70
         /  \     /  \
        20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(70);
        tree.insert(50);
        tree.insert(80);

        tree.inorderRec(tree.root);
    }
}
