/**
 * Date: 09/01/2024:07:39
 * User: shyamlal
 * Problem Description
 * Given the inorder and postorder traversal of a tree, construct the binary tree.
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
 * First argument is an integer array A denoting the inorder traversal of the tree.
 * <p>
 * Second argument is an integer array B denoting the postorder traversal of the tree.
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
 * A = [2, 1, 3]
 * B = [2, 3, 1]
 * Input 2:
 * <p>
 * A = [6, 1, 3, 2]
 * B = [6, 3, 2, 1]
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
public class BTFromInPostOrd {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 3, 1};
        TreeNode root = buildTree(A, B);
        BinaryTFromInPreOrd.printTree(root);
    }

    public static TreeNode CreateTree(int[] in, int[] post, int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }

        TreeNode node = new TreeNode(post[pe]);
        int NodeIndex = is;

        for (int i = is; i <= ie; i++) {
            if (post[pe] == in[i]) {
                NodeIndex = i;
                break;
            }
        }
        int count = ie - NodeIndex;

        // left subtree call
        node.left = CreateTree(in, post, is, NodeIndex - 1, ps, pe - count - 1);
        // right subtree call
        node.right = CreateTree(in, post, NodeIndex + 1, ie, pe - count, pe - 1);

        return node;
    }

    public static TreeNode buildTree(int[] A, int[] B) {
        int n = A.length;

        return CreateTree(A, B, 0, n - 1, 0, n - 1);
    }
}
