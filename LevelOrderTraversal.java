import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 09/01/2024:06:38
 * User: shyamlal
 * Problem Description
 * Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is root node of the binary tree, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a 2D integer array denoting the level order traversal of the given binary tree.
 * <p>
 * <p>
 * <p>
 * Example Input
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
 * Output 1:
 * <p>
 * [
 * [3],
 * [9, 20],
 * [15, 7]
 * ]
 * Output 2:
 * <p>
 * [
 * [1]
 * [6, 2]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Return the 2D array. Each row denotes the traversal of each level.
 */
public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = solve(root);
        for (ArrayList<Integer> ele : res) {
            for (int e : ele) {

                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // final return ArrayList
        q.add(A);  // adding root TreeNode to q
        while (q.size() > 0) {
            int N = q.size();
            ArrayList<Integer> temp = new ArrayList<>();  // creating a new ArrayList for every level
            for (int i = 0; i < N; i++) {  // iterating for each level
                TreeNode t = q.peek();
                temp.add(t.val);
                q.remove();
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
            }
            ans.add(temp);  // adding temp ArrayList to ans ArrayList
        }
        return ans;
    }
}
