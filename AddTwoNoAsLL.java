/**
 * Date: 31/12/2023:15:32
 * User: shyamlal
 * Problem Description
 * You are given two linked lists, A and B, representing two non-negative numbers.
 * <p>
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * <p>
 * Add the two numbers and return it as a linked list.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A|, |B| <= 105
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
 * Return a pointer to the head of the required linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * <p>
 * A = [2, 4, 3]
 * B = [5, 6, 4]
 * Input 2:
 * <p>
 * <p>
 * A = [9, 9]
 * B = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * <p>
 * [7, 0, 8]
 * Output 2:
 * <p>
 * <p>
 * [0, 0, 1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A = 342 and B = 465. A + B = 807.
 * Explanation 2:
 * <p>
 * A = 99 and B = 1. A + B = 100.
 */
public class AddTwoNoAsLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next = new ListNode(6);

        ListNode ln2 = new ListNode(7);
        ln2.next = new ListNode(8);
//        ln2.next.next = ln.next.next.next;
        ListNode resNode = addTwoNumbers(ln, ln2);
        while (resNode != null) {
            System.out.print(resNode.val + "->");
            resNode = resNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        int carry = 0;
        while (A != null || B != null || carry != 0) {
            int sum = 0;
            if (A != null) {
                sum = sum + A.val;
                A = A.next;
            }
            if (B != null) {
                sum = sum + B.val;
                B = B.next;
            }
            //sum+carry
            sum = sum + carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return head.next;
    }
}
