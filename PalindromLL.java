/**
 * Date: 31/12/2023:15:22
 * User: shyamlal
 * Problem Description
 * Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a pointer to the head of the given linked list.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0, if the linked list is not a palindrome.
 * <p>
 * Return 1, if the linked list is a palindrome.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 2, 1]
 * Input 2:
 * <p>
 * A = [1, 3, 2]
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
 * The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
 * Explanation 2:
 * <p>
 * The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].
 * <p>
 * <p>
 * <p>
 * Expected Output
 * Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
 */
public class PalindromLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(1);
//        ln.next.next.next = new ListNode(4);
//        ln.next.next.next.next = new ListNode(5);
//        ln.next.next.next.next.next = new ListNode(6);
        System.out.println(lPalin(ln));
    }

    public static int lPalin(ListNode A) {
        //find middle node
        ListNode mid = findMid(A);
        //reverse the second list
        ListNode head2 = reverse(mid.next);
        ListNode temp = A, temp2 = head2;


        while (temp != null && temp2 != null) {
            if (temp.val != temp2.val) {
                return 0;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return 1;

    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode nh = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = nh;
            nh = temp;
        }
        return nh;
    }
}
