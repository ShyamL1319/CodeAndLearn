/**
 * Date: 10/01/2024:07:47
 * User: shyamlal
 * Problem Description
 * Given a binary search tree.
 * Return the distance between two nodes with given two keys B and C. It may be assumed that both keys exist in BST.
 * <p>
 * NOTE: Distance between two nodes is number of edges between them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 1000000
 * <p>
 * 0 <= node values <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is a root node of the binary tree, A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * Third argument is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the distance between two nodes with given two keys B and C
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 5
 * /   \
 * 2     8
 * / \   / \
 * 1   4 6   11
 * B = 2
 * C = 11
 * Input 2:
 * <p>
 * <p>
 * 6
 * /   \
 * 2     9
 * / \   / \
 * 1   4 7   10
 * B = 2
 * C = 6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Path between 2 and 11 is: 2 -> 5 -> 8 -> 11. Distance will be 3.
 * Explanation 2:
 * <p>
 * Path between 2 and 6 is: 2 -> 6. Distance will be 1
 */
public class DistanceBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(solve(root, 6, 4));
    }

    public static int solve(TreeNode A, int B, int C) {

        TreeNode lca = findLCA(A, B, C);
        int[] d1 = new int[1];
        int[] d2 = new int[1];

        findDistance(lca, B, d1);
        findDistance(lca, C, d2);

        return d1[0] + d2[0];
    }

    public static TreeNode findLCA(TreeNode root, int a, int b) {

        TreeNode curr = root;

        while (true) {

            if (a < curr.val && b < curr.val) {
                curr = curr.left;
            } else if (a > curr.val && b > curr.val) {
                curr = curr.right;
            } else {
                break;
            }
        }

        return curr;
    }

    public static boolean findDistance(TreeNode root, int k, int[] dist) {

        if (root == null) {
            return false;
        }

        if (root.val == k) {
            return true;
        }

        if (findDistance(root.left, k, dist) || findDistance(root.right, k, dist)) {
            dist[0] += 1;
            return true;
        } else {
            return false;
        }
    }
}
