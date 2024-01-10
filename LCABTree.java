import java.util.ArrayList;

/**
 * Date: 10/01/2024:07:05
 * User: shyamlal
 * Problem Description
 * Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
 * <p>
 * Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of tree <= 100000
 * <p>
 * 1 <= B, C <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is head of tree A.
 * <p>
 * Second argument is integer B.
 * <p>
 * Third argument is integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the LCA.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    3
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * 1
 * /  \
 * 2    3
 * / \
 * 4   5
 * B = 4
 * C = 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * LCA is 1.
 * Explanation 2:
 * <p>
 * LCA is 2.
 */
public class LCABTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(lca(root, 9, 15));
    }

    public static int lca(TreeNode A, int B, int C) {

        ArrayList<Integer> pathB = new ArrayList<>();
        ArrayList<Integer> pathC = new ArrayList<>();

        int match = A.val;
        if (!pathFromNodeToRoot(A, B, pathB) || !pathFromNodeToRoot(A, C, pathC)) {
            return -1;
        }


        if (pathFromNodeToRoot(A, B, pathB) && pathFromNodeToRoot(A, C, pathC)) {
            int N = pathB.size();
            int M = pathC.size();
            for (int i = 0; i < Math.min(N, M); i++) {
                if (pathB.get(i).equals(pathC.get(i))) {
                    match = pathB.get(i);
                }
            }
        }

        return match;
    }

    public static boolean pathFromNodeToRoot(TreeNode root, int nodeVal, ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        list.add(root.val);
        if (root.val == nodeVal) {
            return true;
        }

        if (pathFromNodeToRoot(root.left, nodeVal, list) || pathFromNodeToRoot(root.right, nodeVal, list)) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }
}
