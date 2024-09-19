/**
 * Date: 10/01/2024:07:42
 * User: shyamlal
 * Problem Description
 * Given a Binary Search Tree A. Also given are two nodes B and C. Find the lowest common ancestor of the two nodes.
 * <p>
 * Note 1 :- It is guaranteed that the nodes B and C exist.
 * <p>
 * Note 2 :- The LCA of B and C in A is the shared ancestor of B and C that is located farthest from the root.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 105
 * <p>
 * 1 <= B , C <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is a root node of the binary tree, A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * Third argument is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the LCA of the two nodes
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 15
 * /    \
 * 12      20
 * / \    /  \
 * 10  14  16  27
 * /
 * 8
 * <p>
 * B = 8
 * C = 20
 * Input 2:
 * <p>
 * 8
 * / \
 * 6  21
 * / \
 * 1   7
 * <p>
 * B = 7
 * C = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 15
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The LCA of node 8 and 20 is the node 15.
 * Explanation 2:
 * <p>
 * The LCA of node 7 and 1 is the node 6.
 */
public class LCAInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(solve(root, 6, 4));
    }

    public static int solve(TreeNode A, int B, int C) {
        // Recursive Approach
        if (A == null) {
            return -1;
        }

        if (A.val > B && A.val > C) {
            return solve(A.left, B, C);
        } else if (A.val < B && A.val < C) {
            return solve(A.right, B, C);
        }
        return A.val;
    }
}
