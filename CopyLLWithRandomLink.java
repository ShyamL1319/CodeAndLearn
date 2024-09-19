import java.util.HashMap;

/**
 * Date: 01/01/2024:22:05
 * User: shyamlal
 * Problem Description
 * You are given a linked list A
 * Each node in the linked list contains two pointers: a next pointer and a random pointer
 * The next pointer points to the next node in the list
 * The random pointer can point to any node in the list, or it can be NULL
 * Your task is to create a deep copy of the linked list A
 * The copied list should be a completely separate linked list from the original list, but with the same node values and random pointer connections as the original list
 * You should create a new linked list B, where each node in B has the same value as the corresponding node in A
 * The next and random pointers of each node in B should point to the corresponding nodes in B (rather than A)
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= |A| <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a pointer to the head of linked list A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a pointer to the head of the required linked list.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Given list
 * 1 -> 2 -> 3
 * with random pointers going from
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * <p>
 * <p>
 * <p>
 * Example Output
 * 1 -> 2 -> 3
 * with random pointers going from
 * 1 -> 3
 * 2 -> 1
 * 3 -> 1
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * You should return a deep copy of the list. The returned answer should not contain the same node as the original list, but a copy of them. The pointers in the returned list should not link to any node in the original input list.
 */
class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}

public class CopyLLWithRandomLink {
    public static void main(String[] args) {
        RandomListNode ln = new RandomListNode(1);
        ln.next = new RandomListNode(2);
        ln.next.next = new RandomListNode(3);
        ln.random = ln.next.next;
        ln.next.random = ln;
        ln.next.next.random = ln;
//        ln.next.next.next = new RandomListNode(4);
//        ln.next.next.next.next = new RandomListNode(5);
//        ln.next.next.next.next.next = new RandomListNode(6);
        RandomListNode resNode = copyRandomList(ln);
        while (resNode != null) {
            System.out.println("Node data " + resNode.label + "-> Random Node Data " + resNode.random.label);
            resNode = resNode.next;
        }
    }

    public static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        // Step 1: Create a mapping of original nodes to their corresponding new nodes
        HashMap<RandomListNode, RandomListNode> nodeMap = new HashMap<>();
        RandomListNode current = head;

        while (current != null) {
            nodeMap.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        // Step 2: Update next and random pointers of the new nodes based on the mapping
        current = head;
        while (current != null) {
            nodeMap.get(current).next = nodeMap.get(current.next);
            nodeMap.get(current).random = nodeMap.get(current.random);
            current = current.next;
        }

        // Step 3: Return the head of the new linked list
        return nodeMap.get(head);
    }
}
