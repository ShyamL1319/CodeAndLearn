/**
 * Date: 09/01/2024:08:13
 * User: shyamlal
 * Problem Description
 * Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST).
 * <p>
 * A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
 * <p>
 * Note: The 2 values must be returned in ascending order
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is the head of the tree,A
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the 2 elements which need to be swapped.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * / \
 * 2   3
 * Input 2:
 * <p>
 * <p>
 * 2
 * / \
 * 3   1
 * <p>
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 1]
 * Output 2:
 * <p>
 * [3, 1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Swapping 1 and 2 will change the BST to be
 * 2
 * / \
 * 1   3
 * which is a valid BST
 * Explanation 2:
 * <p>
 * Swapping 1 and 3 will change the BST to be
 * 2
 * / \
 * 1   3
 * which is a valid BST
 */
public class RecoverBST {
    static int[] swap = new int[2];
    static TreeNode prev = null;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[] res = recoverTree(root);
        System.out.println(res[0] + ",  " + res[1]);
    }

    public static int[] recoverTree(TreeNode A) {
        findSwapEle(A);
        return swap;
    }

    public static void findSwapEle(TreeNode A) {
        if (A == null) {
            return;
        }

        findSwapEle(A.left);
        // store the values in array according to question if found desceending order.
        if (prev != null && prev.val >= A.val) {
            if (swap[0] == 0) {
                swap[1] = prev.val;
                swap[0] = A.val;
            } else {
                swap[0] = A.val;
            }
        }
        prev = A;
        findSwapEle(A.right);
    }
}
