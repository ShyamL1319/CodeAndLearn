/**
 * Date: 30/12/2023:23:42
 * User: shyamlal
 * Problem Description
 * Given a linked list A, remove the B-th node from the end of the list and return its head.
 * For example, given linked list: 1->2->3->4->5, and B = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * <p>
 * NOTE: If B is greater than the size of the list, remove the first node of the list.
 * <p>
 * Try doing it using constant additional space.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 106
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list. The second argument of input contains the integer B.
 * <p>
 * <p>
 * Output Format
 * Return the head of the linked list after deleting the B-th element from the end.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = 1->2->3->4->5
 * B = 2
 * Input 2:
 * A = 1
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 1->2->3->5
 * Output 2:
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * In the first example, 4 is the second last element.
 * Explanation 2:
 * In the second example, 1 is the first and the last element.
 */


// Definition for singly-linked list.
class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class RemoveNthNodeFromListEnd {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        ListNode resNode = removeNthFromEnd(ln, 2);
        while (resNode != null) {
            System.out.print(resNode.val + "->");
            resNode = resNode.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode A, int B) {
        int length = size(A);

        if (length == 1) {
            return null;
        }
        if (B >= length) {
            A = A.next;
            return A;
        }
        int pos = length - B;
        ListNode temp = A;
        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return A;
    }

    public static int size(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
