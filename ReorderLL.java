/**
 * Date: 31/12/2023:14:46
 * User: shyamlal
 * Problem Description
 * Given a singly linked list A
 * <p>
 * A: A0 → A1 → … → An-1 → An
 * reorder it to:
 * <p>
 * A0 → An → A1 → An-1 → A2 → An-2 → …
 * You must do this in-place without altering the nodes' values.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the linked list A.
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
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 5, 2, 4, 3]
 * Output 2:
 * <p>
 * [1, 4, 2, 3]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The array will be arranged to [A0, An, A1, An-1, A2].
 * Explanation 2:
 * <p>
 * The array will be arranged to [A0, An, A1, An-1, A2].
 */
public class ReorderLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        ListNode resNode = reorderList(ln);
        while (resNode != null) {
            System.out.print(resNode.val + "->");
            resNode = resNode.next;
        }
    }

    public static ListNode reorderList(ListNode A) {
        ListNode h1 = A;
        // ListNode h2 = A;
        if (h1 == null && h1.next == null) {
            return null;
        }
        //finding middle from the linkedlist
        ListNode s = A;
        ListNode f = A;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
        }
        // detach the list and get the sublists
        // sublist 1 from h1 to m
        // sublist 2 after the m and till the last node
        ListNode m = s;
        ListNode h2 = m.next;
        m.next = null;
        // Reverse the  sublist 2
        ListNode rh = null;
        while (h2 != null) {
            ListNode t = h2;
            h2 = h2.next;
            t.next = null;
            t.next = rh;
            rh = t;
        }
        h2 = rh;
        //Merge the two sublists one by one
        ListNode t = h1;
        ListNode h = h1;
        while (h1 != null && h2 != null) {
            h1 = h1.next;
            t.next = h2;
            h2 = h2.next;
            t = t.next;
            t.next = h1;
            t = t.next;
        }
        return h;
    }
}
