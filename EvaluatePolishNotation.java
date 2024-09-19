import java.util.Stack;

/**
 * Date: 01/01/2024:23:24
 * User: shyamlal
 * Problem Description
 * An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each string may be an integer or an operator.
 * <p>
 * Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 9
 * Output 2:
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explaination 1:
 * starting from backside:
 * * : () * ()
 * 3 : () * (3)
 * + : (() + ()) * (3)
 * 1 : (() + (1)) * (3)
 * 2 : ((2) + (1)) * (3)
 * ((2) + (1)) * (3) = 9
 * Explaination 2:
 * starting from backside:
 * + : () + ()
 * / : () + (() / ())
 * 5 : () + (() / (5))
 * 13 : () + ((13) / (5))
 * 4 : (4) + ((13) / (5))
 * (4) + ((13) / (5)) = 6
 */
public class EvaluatePolishNotation {
    public static void main(String[] args) {
        String[] A = {"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(A));
    }

    public static int evalRPN(String[] A) {

        int n = A.length;
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (A[i].equals("+") || A[i].equals("-") || A[i].equals("*") || A[i].equals("/")) {
                char op = A[i].charAt(0);
                int b = stk.pop(), a = stk.pop();
                if (op == '+') {
                    stk.push(a + b);
                } else if (op == '-') {
                    stk.push(a - b);
                } else if (op == '*') {
                    stk.push(a * b);
                } else if (op == '/') {
                    stk.push(a / b);
                }
            } else {
                stk.push(Integer.parseInt(A[i]));
            }
        }
        return stk.pop();
    }
}
