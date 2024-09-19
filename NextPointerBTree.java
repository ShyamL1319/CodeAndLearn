/**
 * Date: 10/01/2024:07:12
 * User: shyamlal
 * Problem Description
 * Given a binary tree,
 * <p>
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Assume perfect binary tree.
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
 * Return the head of the binary tree after the changes are made.
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
 * Input 2:
 * <p>
 * <p>
 * 1
 * /  \
 * 2    5
 * / \  / \
 * 3  4  6  7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * Output 2:
 * <p>
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 5 -> NULL
 * / \  / \
 * 3->4->6->7 -> NULL
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Next pointers are set as given in the output.
 * Explanation 2:
 * <p>
 * Next pointers are set as given in the output.
 */

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class NextPointerBTree {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(9);
        root.right = new TreeLinkNode(20);
        root.right.left = new TreeLinkNode(15);
        root.right.right = new TreeLinkNode(7);
        connect(root);
    }

    public static void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            TreeLinkNode front = q.peek();
            q.remove();

            if (front != null) {
                front.next = q.peek();
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            } else {
                q.add(null);
            }
        }
    }
}
