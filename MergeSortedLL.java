/**
 * Date: 31/12/2023:15:00
 * User: shyamlal
 * Problem Description
 * Merge two sorted linked lists, A and B, and return it as a new list.
 * <p>
 * The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= |A|, |B| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 * <p>
 * The second argument of input contains a pointer to the head of linked list B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a pointer to the head of the merged linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 5 -> 8 -> 20
 * B = 4 -> 11 -> 15
 * Input 2:
 * <p>
 * A = 1 -> 2 -> 3
 * B = Null
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Output 2:
 * <p>
 * 1 -> 2 -> 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
 * Explanation 2:
 * <p>
 * We don't need to merge as B is empty.
 */
public class MergeSortedLL {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = null;
        ListNode tail = null;

        ListNode p1 = A;
        ListNode p2 = B;

        if (p1 == null) {
            return p2;
        } else if (p2 == null) {
            return p1;
        }

        if (p1.val < p2.val) {
            head = p1;
            tail = p1;
            p1 = p1.next;
        } else {
            head = p2;
            tail = p2;
            p2 = p2.next;
        }

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }

        if (p1 != null) {
            tail.next = p1;
        }
        if (p2 != null) {
            tail.next = p2;
        }
        return head;
    }
}
