/**
 * Date: 17/12/2023:14:22
 * User: shyamlal
 * Problem Description
 * <p>
 * Given a binary tree, find and return the sum of node value of all left leaves in it.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= number of nodes <= 5 * 105
 * <p>
 * 1 <= node value <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First and only argument is a pointer to the root node of the Binary Tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the sum of node value of all left leaves in it.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Input 2:
 * <p>
 * 1
 * / \
 * 6   2
 * /
 * 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 24
 * Output 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Left leaf node in the given tree are 9 and 15. Return 24 (9 + 15).
 * Explanation 2:
 * <p>
 * Left leaf node in the given tree are 6 and 3. Return 9 (6 + 3).
 */

public class SumLeftLeaves {
    static int sum = 0;

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(5);
        t.right = new TreeNode(6);
        t.right.left = new TreeNode(15);
        t.right.right = new TreeNode(9);
        System.out.println(solve(t));
    }

    public static int solve(TreeNode A) {
        if (A == null) {
            return 0;
        }
        if (A.left != null && A.left.left == null && A.left.right == null) { //finding here leaf node
            sum = sum + A.left.val;
        } else {
            solve(A.left);
        }
        solve(A.right);
        return sum;
    }
}
