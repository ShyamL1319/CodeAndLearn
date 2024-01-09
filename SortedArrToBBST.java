/**
 * Date: 09/01/2024:08:03
 * User: shyamlal
 * Problem Description
 * Given an array where elements are sorted in ascending order, convert it to a height Balanced Binary Search Tree (BBST).
 * <p>
 * Balanced tree : a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of array <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a root node of the Binary Search Tree.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A : [1, 2, 3]
 * Input 2:
 * <p>
 * A : [1, 2, 3, 5, 10]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * /   \
 * 1     3
 * Output 2:
 * <p>
 * 3
 * /   \
 * 2     5
 * /       \
 * 1         10
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * You need to return the root node of the Binary Tree.
 */
public class SortedArrToBBST {
    public static void main(String[] args) {
        int[] B = {1, 2, 3};
        TreeNode root = sortedArrayToBST(B);
        BinaryTFromInPreOrd.printTree(root);
    }

    public static TreeNode sortedArrayToBST(final int[] A) {
        return constructBinaryTree(A, 0, A.length - 1);
    }

    public static TreeNode constructBinaryTree(int[] arr, int low, int high) {

        if (low > high) {
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = constructBinaryTree(arr, low, mid - 1);
        root.right = constructBinaryTree(arr, mid + 1, high);
        return root;
    }
}
