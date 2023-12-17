/**
 * Date: 17/12/2023:14:03
 * User: shyamlal
 * Problem Description
 * Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestors.
 * <p>
 * Ancestor means that every node that occurs before the current node in the path from root to the node.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of Nodes <= 200000
 * <p>
 * 1 <= Value of Nodes <= 2000000000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument of input is a tree node.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting the count of nodes that have more value than all of its ancestors.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 3
 * Input 2:
 * <p>
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There's only one node in the tree that is the valid node.
 * Explanation 2:
 * <p>
 * The valid nodes are 4, 5 and 6.
 */

// Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class CountingNodes {
    static int count = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode A = new TreeNode(10);
        int cnt = countNode(A, Integer.MIN_VALUE);
    }

    public static int countNode(TreeNode A, int max) {
        if (A == null) {
            return 0;
        }
        // checking max val of current node
        if (max < A.val) {
            count++;
            max = A.val;
        }
        countNode(A.left, max); // checking for left side
        countNode(A.right, max); // checking for right side

        return count;
    }
}
