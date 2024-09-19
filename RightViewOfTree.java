import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Date: 09/01/2024:07:06
 * User: shyamlal
 */
public class RightViewOfTree {
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
        res = rightView(root);
        for (int e : res) {

            System.out.print(e + ", ");
        }
    }

    // Recursive function to traverse leftmost nodes.
    public static void rightV(TreeNode root, int level, ArrayList<Integer> ans) {
        if (root == null) return;

        // Update leftmost node for each level.
        if (level > mLevel) {
            ans.add(root.val);
            mLevel = level;
        }
        rightV(root.right, level + 1, ans); // Traverse right subtree.
        rightV(root.left, level + 1, ans); // Traverse left subtree.

    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        rightV(A, 0, ans); // Start traversal from the root.
        return ans;
    }

    public static ArrayList<Integer> rightView(TreeNode A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        que.add(A);

        while (que.size() > 0) {
            int sz = que.size();

            ans.add(que.peek().val);

            for (int i = 0; i < sz; i++) {
                TreeNode rem = que.remove();
                if (rem.right != null) {
                    que.add(rem.right);
                }
                if (rem.left != null) {
                    que.add(rem.left);
                }
            }
        }
        return ans;
    }
}
