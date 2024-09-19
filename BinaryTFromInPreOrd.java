/**
 * Date: 09/01/2024:07:15
 * User: shyamlal
 * Problem Description
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * NOTE: You may assume that duplicates do not exist in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A denoting the preorder traversal of the tree.
 * <p>
 * Second argument is an integer array B denoting the inorder traversal of the tree.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the root node of the binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3]
 * B = [2, 1, 3]
 * Input 2:
 * <p>
 * A = [1, 6, 2, 3]
 * B = [6, 1, 3, 2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Output 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Create the binary tree and return the root node of the tree.
 */
public class BinaryTFromInPreOrd {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 1, 3};
        TreeNode root = buildTree(A, B);
        printTree(root);
    }

    public static TreeNode buildTree(int[] A, int[] B) {
        int n = A.length;
        return constructTree(0, n - 1, 0, n - 1, A, B);
    }

    public static TreeNode constructTree(int pre_s, int pre_e, int ino_s, int ino_e, int[] preorder, int[] inorder) {
        int index = 0;
        if (pre_s > pre_e || ino_s > ino_e) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_s]);
        for (int i = ino_s; i <= ino_e; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        int r = pre_s + index - ino_s;
        root.left = constructTree(pre_s + 1, r, ino_s, index - 1, preorder, inorder);
        root.right = constructTree(r + 1, pre_e, index + 1, ino_e, preorder, inorder);
        return root;

    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }
}
