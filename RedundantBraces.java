import java.util.Stack;

/**
 * Date: 03/01/2024:23:05
 * User: shyamlal
 * Problem Description
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 * <p>
 * Check whether A has redundant braces or not.
 * <p>
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if A has redundant braces else, return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "((a+b))"
 * Input 2:
 * <p>
 * A = "(a+(a+b))"
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
 * ((a+b)) has redundant braces so answer will be 1.
 * Explanation 2:
 * <p>
 * (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {
    public static void main(String[] args) {
        System.out.println(braces("((a+b))"));
    }

    public static int braces(String A) {
        int n = A.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char ch = A.charAt(i);

            if (ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                st.push(ch);
            } else if (ch == ')') {
                if (st.peek() == '(') {
                    return 1;
                } else {
                    while (st.size() > 0 && st.peek() != '(') {
                        st.pop();
                    }
                    st.pop(); // removing the ')' braket
                }
            } else {
                continue;
            }
        }
        return 0;
    }
}
