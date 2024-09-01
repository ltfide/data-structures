package problem;

/*
 * Calculate depth of a full binary tree from preorder
 * Author: Lutfi
 * Date  : 01-09-2024
 */
public class CalculateDepthPreorder {
    
    /**
     * Function to return max
     * of left subtree height
     * of right subtre height
     */
    static int findDepthRec(String tree, int n, int index) {
        if (index >= n || tree.charAt(index) == 'l') {
            return 0;
        }

        index++;
        int left = findDepthRec(tree, n, index);
        System.out.println("Left:  " + left + " Index: " + index);

        index++;
        int right = findDepthRec(tree, n, index);
        System.out.println("====");
        System.out.println("Right: " + right + " Index: " + index);

        return Math.max(left, right) + 1;
    }

    static int findDepth(String tree, int n) {
        int index = 0;
        return findDepthRec(tree, n, index);
    }

    public static void main(String[] args) {
        /*
                n
              /   \
             l     n
                  / \
                 n   l
                /     \
               l       l 
         
        */
        String tree = "nlnnlll";
        int n = tree.length();
        System.out.println("Total: " + findDepth(tree, n));

        /* Output
           Left:  0 Index: 1
           Left:  0 Index: 4
           ====
           Right: 0 Index: 5
           Left:  1 Index: 3
           ====
           Right: 0 Index: 4
           ====
           Right: 2 Index: 2
           Total: 3
         */
    }
}
