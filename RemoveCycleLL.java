/**
 * Date: 31/12/2023:14:55
 * User: shyamlal
 * Problem Description
 * You are given a linked list that contains a loop.
 * You need to find the node, which creates a loop and break it by making the node point to NULL.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= number of nodes <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first of the input contains a LinkedList, where the first number is the number of nodes N, and the next N nodes are the node value of the linked list.
 * The second line of the input contains an integer which denotes the position of node where cycle starts.
 * <p>
 * <p>
 * <p>
 * Output Format
 * return the head of the updated linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * 1 -> 2
 * ^    |
 * | - -
 * Input 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6
 * ^         |
 * |         |
 * - - - - - -
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1 -> 2 -> NULL
 * Output 2:
 * <p>
 * 3 -> 2 -> 4 -> 5 -> 6 -> NULL
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Chain of 1->2 is broken.
 * Explanation 2:
 * <p>
 * Chain of 4->6 is broken.
 */
public class RemoveCycleLL {
    public static void main(String[] args) {

    }

    public static ListNode solve(ListNode A) {

        ListNode tempHead = A;
        ListNode kthPoint = cyclePresent(tempHead);
        if (kthPoint == null) { // No cycle is present
            return A;
        }
        ListNode slow = A;
        ListNode fast = kthPoint;
        ListNode prev = null;
        while (fast != slow) {
            prev = fast;      // store the previous node of the cycle stsrting point
            fast = fast.next;
            slow = slow.next;
        }
        // System.out.print(fast.val + " " + prev.val);
        prev.next = null;   // Breaking the cycle
        return A;
    }

    private static ListNode cyclePresent(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null || fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) {
                return fast;
            }
        }
        return null;
    }
}
