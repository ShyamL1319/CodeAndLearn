/**
 * Date: 09/01/2024:08:32
 * User: shyamlal
 * Problem Description
 * Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes in binary tree <= 100000
 * <p>
 * 0 <= node values <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is head of the binary tree A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the Bth element.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 2
 * /   \
 * 1    3
 * B = 2
 * Input 2:
 * <p>
 * <p>
 * 3
 * /
 * 2
 * /
 * 1
 * B = 1
 * <p>
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 2nd element is 2.
 * Explanation 2:
 * <p>
 * 1st element is 1.
 */
public class KthSmallestEleBST {
    int ans = -1;
    int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        KthSmallestEleBST ksb = new KthSmallestEleBST();
        System.out.println(ksb.kthsmallest(root, 2));
    }

    public int kthsmallest(TreeNode A, int B) {
        inOrder(A, B);
        return ans;
    }

    public void inOrder(TreeNode root, int B) {

        if (root == null) {
            return;
        }
        inOrder(root.left, B);
        count++;
        if (count == B) {
            ans = root.val;
            return;
        }
        inOrder(root.right, B);
    }
}
