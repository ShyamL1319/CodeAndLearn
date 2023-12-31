/**
 * Date: 31/12/2023:15:07
 * User: shyamlal
 * Problem Description
 * Write a program to find the node at which the intersection of two singly linked lists, A and B, begins. For example, the following two linked lists:
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * NOTE:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * The custom input to be given is different than the one explained in the examples. Please be careful.
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= |A|, |B| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a pointer to the head of the linked list A.
 * <p>
 * The second argument of input contains a pointer to the head of the linked list B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a pointer to the node after which the linked list is intersecting.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = [6, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * B = [4, 5]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [3, 4, 5]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * In the first example, the nodes have the same values after 3rd node in A and 2nd node in B. Thus, the linked lists are intersecting after that point.
 * Explanation 2:
 * <p>
 * In the second example, the nodes don't have the same values, thus we can return None/Null.
 */
public class InterSectionOfLL {
    public static void main(String[] args) {
        ListNode ln = new ListNode(1);
        ln.next = new ListNode(2);
        ln.next.next = new ListNode(3);
        ln.next.next.next = new ListNode(4);
        ln.next.next.next.next = new ListNode(5);
        ln.next.next.next.next.next = new ListNode(6);

        ListNode ln2 = new ListNode(7);
        ln2.next = new ListNode(8);
        ln2.next.next = ln.next.next.next;
        ListNode resNode = getIntersectionNode(ln, ln2);
        System.out.print(resNode.val);
    }

    public static ListNode getIntersectionNode(ListNode A, ListNode B) {
        int t1 = size(A);
        int t2 = size(B);
        int stpos = Math.abs(t1 - t2);
        if (t1 > t2) {
            for (int i = 0; i < stpos; i++) {
                A = A.next;
            }
        } else {
            for (int i = 0; i < stpos; i++) {
                B = B.next;
            }
        }
        while (A != B) {
            A = A.next;
            B = B.next;
        }
        return A;

    }

    public static int size(ListNode A) {
        int cnt = 0;
        while (A != null) {
            cnt++;
            A = A.next;
        }
        return cnt;
    }
}
