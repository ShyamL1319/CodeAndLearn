import java.util.Stack;

/**
 * Date: 04/01/2024:22:58
 * User: shyamlal
 * Problem Description
 * <p>
 * Design a stack that supports push, pop, top, and retrieve the minimum element in constant time.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * NOTE:
 * All the operations have to be constant time operations.
 * getMin() should return -1 if the stack is empty.
 * pop() should return nothing if the stack is empty.
 * top() should return -1 if the stack is empty.
 * Problem Constraints
 * <p>
 * 1 <= Number of Function calls <= 107
 * Input Format
 * <p>
 * Functions will be called by the checker code automatically.
 * Output Format
 * <p>
 * Each function should return the values as defined by the problem statement.
 * Example Input
 * <p>
 * Input 1:
 * push(1)
 * push(2)
 * push(-2)
 * getMin()
 * pop()
 * getMin()
 * top()
 * Input 2:
 * getMin()
 * pop()
 * top()
 * Example Output
 * <p>
 * Output 1:
 * -2 1 2
 * Output 2:
 * -1 -1
 * Example Explanation
 * <p>
 * Explanation 1:
 * Let the initial stack be : []
 * 1) push(1) : [1]
 * 2) push(2) : [1, 2]
 * 3) push(-2) : [1, 2, -2]
 * 4) getMin() : Returns -2 as the minimum element in the stack is -2.
 * 5) pop() : Return -2 as -2 is the topmost element in the stack.
 * 6) getMin() : Returns 1 as the minimum element in stack is 1.
 * 7) top() : Return 2 as 2 is the topmost element in the stack.
 * Explanation 2:
 * Let the initial stack be : []
 * 1) getMin() : Returns -1 as the stack is empty.
 * 2) pop() :  Returns nothing as the stack is empty.
 * 3) top() : Returns -1 as the stack is empty.
 */
public class MinStack {
    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        push(1);
        push(2);
        push(-2);
        getMin();
        pop();
        getMin();
        top();
    }

    public static void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public static void pop() {
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }
    }

    public static int top() {
        if (stack.isEmpty()) {
            return -1; // or throw an exception as per your requirement
        }
        return stack.peek();
    }

    public static int getMin() {
        if (minStack.isEmpty()) {
            return -1; // or throw an exception as per your requirement
        }
        return minStack.peek();
    }
}
