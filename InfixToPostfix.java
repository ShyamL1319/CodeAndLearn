import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Date: 02/01/2024:23:17
 * User: shyamlal
 * Problem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 * <p>
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 * <p>
 * Find and return the postfix expression of A.
 * <p>
 * NOTE:
 * <p>
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the string <= 500000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string denoting the postfix conversion of A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "x^y/(a*z)+b"
 * Input 2:
 * <p>
 * A = "a+b*(c^d-e)^(f+g*h)-i"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "xy^az*'/b+"
 * Output 2:
 * <p>
 * "abcd^e-fgh*+^*+i-"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Ouput dentotes the postfix expression of the given input.
 */
public class InfixToPostfix {
    public static void main(String[] args) {
        String A = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(solve(A));
    }

    public static String solve(String A) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> operators = new Stack();
        int i = 0;
        Map<Character, Integer> precedence = new HashMap();
        precedence.put('^', 3);
        precedence.put('*', 2);
        precedence.put('/', 2);
        precedence.put('+', 1);
        precedence.put('-', 1);
        while (i < A.length()) {
            char ch = A.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                ans.append(ch);
            } else {
                if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        ans.append(operators.pop());
                    }
                    operators.pop();
                } else if (isOperator(ch) && (operators.isEmpty() || operators.peek() == '(' || precedence.get(ch) > precedence.get(operators.peek()))) {
                    operators.push(ch);
                } else if (isOperator(ch) && (precedence.get(ch) <= precedence.get(operators.peek()))) {
                    while (!operators.isEmpty() && operators.peek() != '(' && precedence.get(ch) <= precedence.get(operators.peek())) {
                        ans.append(operators.pop());
                    }
                    operators.push(ch);
                }
            }
            i++;
        }
        while (!operators.isEmpty()) {
            ans.append(operators.pop());
        }
        return ans.toString();
    }

    public static boolean isOperator(char ch) {
        return ch == '^' || ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }
}
