/**
 * Date: 10/01/2024:07:24
 * User: shyamlal
 * Problem Description
 * Given a binary tree. Check whether the given tree is a Sum-binary Tree or not.
 * <p>
 * Sum-binary Tree is a Binary Tree where the value of a every node is equal to sum of the nodes present in its left subtree and right subtree.
 * <p>
 * An empty tree is Sum-binary Tree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 * <p>
 * Return 1 if it sum-binary tree else return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * <p>
 * 0 <= node values <= 50
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the root node of tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if it is sum-binary tree else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 26
 * /    \
 * 10     3
 * /  \     \
 * 4   6      3
 * Input 2:
 * <p>
 * 26
 * /    \
 * 10     3
 * /  \     \
 * 4   6      4
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
 * All leaf nodes are considered as SumTree.
 * Value of Node 10 = 4 + 6.
 * Value of Node 3 = 0 + 3
 * Value of Node 26 = (10 + 4 + 6) + 6
 * Explanation 2:
 * <p>
 * Sum of left subtree and right subtree is 27 which is not equal to the value of root node which is 26.
 */
public class IsSumBTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(26);
        root.left = new TreeNode(10);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(3);
        System.out.println(solve(root));
    }

    public static int solve(TreeNode A) {
        if (A == null) return 0;
        int left = sum(A.left);
        int right = sum(A.right);
        if (A.val == left + right) return 1;
        return 0;
    }


    public static int sum(TreeNode A) {
        if (A == null) return 0;
        return A.val + sum(A.left) + sum(A.right);
    }
}
