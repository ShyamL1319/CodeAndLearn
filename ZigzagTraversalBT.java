import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 09/01/2024:07:29
 * User: shyamlal
 * Problem Description
 * Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
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
 * Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
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
 * [20, 9],
 * [15, 7]
 * ]
 * Output 2:
 * <p>
 * [
 * [1]
 * [2, 6]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Return the 2D array. Each row denotes the zigzag traversal of each level.
 */
public class ZigzagTraversalBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> res = zigzagLevelOrder(root);
        for (ArrayList<Integer> ele : res) {
            for (int e : ele) {

                System.out.print(e + ", ");
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (A == null) {
            return ans;
        }
        //Insert the  root element innto queue intially
        q.offer(A);
        boolean flag = true;
        while (!q.isEmpty()) {
            int level = q.size();
            ArrayList<Integer> subList = new ArrayList<>(level);

            for (int i = 0; i < level; i++) {
                TreeNode f = q.peek();
                if (f.left != null) {
                    q.add(f.left);
                }
                if (f.right != null) {
                    q.add(f.right);
                }

                if (flag) {
                    //insert the value at the end of the subList
                    subList.add(q.poll().val);
                } else {
                    //insert the value at the beginning of the subList
                    subList.add(0, q.poll().val);
                }
            }
            flag = !flag;
            ans.add(subList);
        }
        return ans;
    }
}
