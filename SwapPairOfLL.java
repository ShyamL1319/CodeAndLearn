/**
 * Date: 31/12/2023:15:35
 * User: shyamlal
 * Problem Description
 * Given a linked list A, swap every two adjacent nodes and return its head.
 * <p>
 * NOTE: Your algorithm should use only constant space. You may not modify the values in the list; only nodes themselves can be changed.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a pointer to the head of the modified linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 1 -> 2 -> 3 -> 4
 * Input 2:
 * <p>
 * A = 7 -> 2 -> 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2 -> 1 -> 4 -> 3
 * Output 2:
 * <p>
 * 2 -> 7 -> 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * In the first example (1, 2) and (3, 4) are the adjacent nodes. Swapping them will result in 2 -> 1 -> 4 -> 3
 * Explanation 2:
 * <p>
 * In the second example, 3rd element i.e. 1 does not have an adjacent node, so it won't be swapped.
 */
public class SwapPairOfLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next = new ListNode(6);

//        ListNode ln2 = new ListNode(7);
//        ln2.next = new ListNode(8);
//        ln2.next.next = ln.next.next.next;
        ListNode resNode = swapPairs(ln);
        while (resNode != null) {
            System.out.print(resNode.val + "->");
            resNode = resNode.next;
        }
    }

    public static ListNode swapPairs(ListNode A) {
        ListNode start = A;
        while (start != null && start.next != null) {
            int temp_data = start.val;
            start.val = start.next.val;
            start.next.val = temp_data;
            start = start.next.next;
        }
        return A;
    }
}
