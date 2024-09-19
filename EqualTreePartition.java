/**
 * Date: 10/01/2024:07:34
 * User: shyamlal
 * Problem Description
 * Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * 0 <= value of node <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is head of tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if the tree can be partitioned into two trees of equal sum else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 5
 * /  \
 * 3    7
 * / \  / \
 * 4  6  5  6
 * Input 2:
 * <p>
 * <p>
 * 1
 * / \
 * 2   10
 * / \
 * 20  2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Remove edge between 5(root node) and 7:
 * Tree 1 =                                               Tree 2 =
 * 5                                                     7
 * /                                                     / \
 * 3                                                     5   6
 * / \
 * 4   6
 * Sum of Tree 1 = Sum of Tree 2 = 18
 * Explanation 2:
 * <p>
 * The given Tree cannot be partitioned.
 */
public class EqualTreePartition {
    static long sum = 0;     //here take the datatype of sum as long not int because size of tree is upto 10^5 and value of a node can be upto 10^9 so sum goes upto 10^14 which can't be handle by int datatype
    static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(solve(root));
    }

    public static int solve(TreeNode A) {
        sum = getSum(A);
        if (sum % 2 != 0) {
            return 0;
        } else {
            modifiedSum(A, sum);
            return ans;
        }

    }

    public static long modifiedSum(TreeNode root, long s) {
        if (root == null) {
            return 0;
        }
        long l = modifiedSum(root.left, s);
        long r = modifiedSum(root.right, s);
        if (l == s / 2 || r == s / 2) {
            ans = 1;
        }
        return l + r + root.val;
    }

    public static long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + getSum(root.left) + getSum(root.right);
    }


}
