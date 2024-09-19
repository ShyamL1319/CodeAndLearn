import java.util.Stack;

/**
 * Date: 07/01/2024:23:30
 * User: shyamlal
 * Problem Description
 * <p>
 * Implement a First In First Out (FIFO) queue using stacks only.
 * <p>
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
 * <p>
 * Implement the UserQueue class:
 * <p>
 * void push(int X) : Pushes element X to the back of the queue.
 * int pop() : Removes the element from the front of the queue and returns it.
 * int peek() : Returns the element at the front of the queue.
 * boolean empty() : Returns true if the queue is empty, false otherwise.
 * NOTES:
 * <p>
 * You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= X <= 109
 * <p>
 * At most 1000 calls will be made to push, pop, peek, and empty function.
 * <p>
 * All the calls to pop and peek are valid. i.e. pop and peek are called only when the queue is non-empty.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * 1) UserQueue()
 * 2) push(20)
 * 3) empty()
 * 4) peek()
 * 5) pop()
 * 6) empty()
 * 7) push(30)
 * 8) peek()
 * 9) push(40)
 * 10) peek()
 * Input 2:
 * <p>
 * 1) UserQueue()
 * 2) push(10)
 * 3) push(20)
 * 4) push(30)
 * 5) pop()
 * 6) pop()
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * false
 * 20
 * 20
 * true
 * 30
 * 30
 * Output 2:
 * <p>
 * 10
 * 20
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Queue => 20
 * Queue => -
 * Queue => 30
 * Queue => 30, 40
 * Explanation 2:
 * <p>
 * Queue => 10
 * Queue => 10, 20
 * Queue => 10, 20, 30
 * Queue => 20, 30
 * Queue => 30
 */
public class QueueByStack {
    /**
     * Initialize your data structure here.
     */
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    QueueByStack() {

    }

    public static void main(String[] args) {
        new QueueByStack();
        push(20);
        empty();
        System.out.println(peek());
        System.out.println(pop());
        empty();
        push(30);
        System.out.println(peek());
        push(40);
        System.out.println(peek());
    }

    /**
     * Push element X to the back of queue.
     */
    static void push(int X) {
        s1.push(X);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    static int pop() {
        //transfer  all elements from s1 to s2.
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }
            return s2.pop();
        } else {
            return s2.pop();
        }
    }

    /**
     * Get the front element of the queue.
     */
    static int peek() {
        //transfer  all elements from s1 to s2.
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int temp = s1.pop();
                s2.push(temp);
            }
            return s2.peek();
        } else {
            return s2.peek();
        }
    }

    /**
     * Returns whether the queue is empty.
     */
    static boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
