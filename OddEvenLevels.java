import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 09/01/2024:07:34
 * User: shyamlal
 * Problem Description
 * Given a binary tree of integers. Find the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * NOTE: Consider the level of root node as 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a root node of the binary tree, A
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the difference between the sum of nodes at odd level and sum of nodes at even level.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2     3
 * / \   / \
 * 4   5 6   7
 * /
 * 8
 * Input 2:
 * <p>
 * 1
 * / \
 * 2   10
 * \
 * 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * -7
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Sum of nodes at odd level = 23
 * Sum of ndoes at even level = 13
 * Explanation 2:
 * <p>
 * Sum of nodes at odd level = 5
 * Sum of ndoes at even level = 12
 */
public class OddEvenLevels {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(solve(root));
    }

    public static int solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(A);
        int count = 1;
        int oddSum = 0;
        int evenSum = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 1; i <= n; i++) {
                TreeNode curr = q.peek();
                q.remove();
                //based on level i adds to oddSum or evenSum
                if (count % 2 == 1) {
                    oddSum += curr.val;
                } else {
                    evenSum += curr.val;
                }
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            count++;
        }
        return oddSum - evenSum;
    }
}
