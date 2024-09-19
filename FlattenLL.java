/**
 * Date: 01/01/2024:22:19
 * User: shyamlal
 */
class ListNode1 {
    int val;
    ListNode1 right, down;

    ListNode1(int x) {
        val = x;
        right = down = null;
    }
}

public class FlattenLL {
    public static void main(String[] args) {
        ListNode1 ln = new ListNode1(1);
        ln.right = new ListNode1(2);
        ln.right.right = new ListNode1(3);
        ln.right.right.right = new ListNode1(4);
        ln.right.right.right.right = new ListNode1(5);
        ln.right.right.right.right.right = new ListNode1(6);
        ListNode1 resNode = flatten(ln);

        while (resNode != null) {
            System.out.print(resNode.val + "->");
            resNode = resNode.right;
        }
    }

    static ListNode1 flatten(ListNode1 root) {
        if (root == null || root.right == null) {
            return root;
        }
        // Dividing the List into two halves
        ListNode1 headA = root;
        ListNode1 headB = headA.right;
        headA.right = null;
        // flatten the lists individually
        headA = flatten(headA);
        headB = flatten(headB);
        // merge the two sorted Linked Lists
        return mergeTwoSortedLists(headA, headB);
    }

    public static ListNode1 mergeTwoSortedLists(ListNode1 headA, ListNode1 headB) {
        if (headA == null) {
            return headB;
        }

        if (headB == null) {
            return headA;
        }

        ListNode1 newHead = null;
        if (headA.val <= headB.val) {
            newHead = headA;
            headA = headA.down;
        } else {
            newHead = headB;
            headB = headB.down;
        }

        ListNode1 temp = newHead;

        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                temp.down = headA;
                temp = temp.down;
                headA = headA.down;
            } else {
                temp.down = headB;
                temp = temp.down;
                headB = headB.down;
            }
        }

        if (headA == null) {
            temp.down = headB;
        }

        if (headB == null) {
            temp.down = headA;
        }

        return newHead;

    }
}
