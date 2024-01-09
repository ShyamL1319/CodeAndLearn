import java.util.HashSet;

/**
 * Date: 09/01/2024:08:26
 * User: shyamlal
 * Problem Description
 * Given a binary search tree A, where each node contains a positive integer, and an integer B, you have to find whether or not there exist two different nodes X and Y such that X.value + Y.value = B.
 * <p>
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * 1 <= B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is the head of the tree A.
 * <p>
 * Second argument is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if such a pair can be found, 0 otherwise.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 10
 * / \
 * 9   20
 * <p>
 * B = 19
 * Input 2:
 * <p>
 * <p>
 * 10
 * / \
 * 9   20
 * <p>
 * B = 40
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 10 + 9 = 19. Hence 1 is returned.
 * Explanation 2:
 * <p>
 * No such pair exists.
 */
public class TwoSumBST {
    static HashSet<Integer> nodeValues = new HashSet<>();
    static boolean flag = false;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(t2Sum(root, 3));
    }

    public static int t2Sum(TreeNode A, int B) {
        checkSum(A, B);
        if (flag) {
            return 1;
        }
        return 0;
    }

    public static void checkSum(TreeNode A, int B) {
        if (A == null) {
            return;
        }
        //check whether 19- 10 is present in HashSet
        int value = B - A.val;
        //if present pair found make flag true and return
        if (nodeValues.contains(value)) {
            flag = true;
            return;
        }
        // add 10 . there may a pair where 10 is one of the value.
        nodeValues.add(A.val);
        // check left. all parent values are there in hashset.
        checkSum(A.left, B);
        checkSum(A.right, B);

    }
}
