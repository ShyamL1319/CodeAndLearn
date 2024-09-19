/**
 * Date: 08/01/2024:08:06
 * User: shyamlal
 * Problem Description
 * <p>
 * Given a binary tree with root node pointer A . The depth of each node is the shortest distance to the root. A node is deepest if it has the largest depth possible among any node in the entire tree.
 * The subtree of a node is that node, plus the set of all descendants of that node.
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes of the entire tree lies in its subtree.
 * <p>
 * NOTE: All nodes values are uniques in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Total number of nodes <= 100000
 * 0 <= Nodes values <= 10
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only arguments given are root pointer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the node with the largest depth such that it contains all the deepest nodes of the entire tree lies in its subtree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * 1
 * / \
 * 2   3
 * / \  \
 * 6   4  5
 * / \
 * 12  13
 * <p>
 * <p>
 * Example Output
 * <p>
 * 4
 * / \
 * 12  13
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Considering depth of root node as 0.
 * Maximum depth is 3.
 * Node with value 12 has depth 3.
 * Node with value 13 has depth 3.
 * Smallest subtree which contains 12 and 13 is (4,12,13).
 */
public class SmallestSubtreeWithDeepestNode {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(12);
        root.right = new TreeNode(13);
        System.out.println(solve(root).val);
    }

    public static TreeNode solve(TreeNode A) {
        //base case
        if (A == null) {
            return null;
        }
        int left = depth(A.left);
        int right = depth(A.right);
        if (left == right) {
            return A;
        }
        if (left > right) {
            return solve(A.left);
        }
        return solve(A.right);
    }

    public static int depth(TreeNode A) {
        if (A == null) {
            return -1;
        }
        return 1 + Math.max(depth(A.left), depth(A.right));
    }
}
