import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Date: 09/01/2024:06:55
 * User: shyamlal
 * Problem Description
 * Given a binary tree of integers. Return an array of integers representing the left view of the Binary tree.
 * <p>
 * Left view of a Binary Tree is a set of nodes visible when the tree is visited from Left side
 * <p>
 * NOTE: The value comes first in the array which have lower level.
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
 * First and only argument is a root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the left view of the Binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * /   \
 * 2    3
 * / \  / \
 * 4   5 6  7
 * /
 * 8
 * Input 2:
 * <p>
 * 1
 * /  \
 * 2    3
 * \
 * 4
 * \
 * 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 4, 8]
 * Output 2:
 * <p>
 * [1, 2, 4, 5]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Left view of the binary tree is returned.
 */
public class LeftViewOfTree {
    static int mLevel = -1;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<Integer> res = solve(root);
        for (int e : res) {

            System.out.print(e + ", ");
        }
        System.out.println();
        res = leftView(root);
        for (int e : res) {

            System.out.print(e + ", ");
        }
    }

    // Recursive function to traverse leftmost nodes.
    public static void leftV(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null) return;

        // Update leftmost node for each level.
        if (level > mLevel) {
            ans.add(root.val);
            mLevel = level;
        }

        leftV(root.left, level + 1, ans); // Traverse left subtree.
        leftV(root.right, level + 1, ans); // Traverse right subtree.
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        leftV(A, 0, ans); // Start traversal from the root.
        return ans;
    }

    public static ArrayList<Integer> leftView(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(A);

        while (que.size() > 0) {
            int sz = que.size();

            ans.add(que.peek().val);

            for (int i = 0; i < sz; i++) {
                TreeNode rem = que.remove();

                if (rem.left != null) {
                    que.add(rem.left);
                }
                if (rem.right != null) {
                    que.add(rem.right);
                }
            }
        }
        return ans;
    }
}
