import java.util.ArrayList;

/**
 * Date: 09/01/2024:07:48
 * User: shyamlal
 * Problem Description
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from the root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * <p>
 * Left boundary is defined as the path from the root to the left-most node.
 * Right boundary is defined as the path from the root to the right-most node.
 * <p>
 * If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Return an array of integers denoting the boundary values of tree in anti-clockwise order.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 105
 * 0 <= node values <= 109
 * <p>
 * <p>
 * Input Format
 * The Only Argument is the Root of the Binary Tree, A.
 * <p>
 * <p>
 * Output Format
 * Return an array of integers denoting the boundary values of tree in anti-clockwise order.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * _____1_____
 * /           \
 * 2             3
 * / \            /
 * 4   5          6
 * / \        / \
 * 7   8      9  10
 * Input 2:
 * 1
 * / \
 * 2   3
 * / \  / \
 * 4   5 6  7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [1, 2, 4, 7, 8, 9, 10, 6, 3]
 * Output 2:
 * [1, 2, 4, 5, 6, 7, 3]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * The left boundary are node 1, 2, 4. (4 is the left-most node according to definition)
 * The leaves are node 4, 7, 8, 9, 10.
 * The right boundary are node 1, 3, 6, 10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1, 2, 4, 7, 8, 9, 10, 6, 3].
 * Explanation 2:
 * The left boundary are node 1, 2, 4. (4 is the left-most node according to definition)
 * The leaves are node 4, 5, 6, 7.
 * The right boundary are node 1, 3, 7. (7 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1, 2, 4, 5, 6, 7, 3].
 */
public class BoundryTraversalOfTree {
    static ArrayList<Integer> ans = new ArrayList<>();

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
    }

    public static ArrayList<Integer> solve(TreeNode A) {
        ans.add(A.val);
        leftBoundary(A.left);
        leafNodes(A);
        rightBoundary(A.right);
        return ans;
    }

    private static void leftBoundary(TreeNode node) {
        while (!(node.left == null && node.right == null)) {
            ans.add(node.val);
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void rightBoundary(TreeNode node) {
        ArrayList<Integer> rightBdr = new ArrayList<>();
        while (!(node.left == null && node.right == null)) {
            rightBdr.add(0, node.val); // Add elements at 0th index for reverse order
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        ans.addAll(rightBdr);
    }

    private static void leafNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        leafNodes(root.left);

        if (root.left == null && root.right == null) {
            ans.add(root.val);
        }
        leafNodes(root.right);
    }
}
