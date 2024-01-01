import java.util.Stack;

/**
 * Date: 01/01/2024:23:34
 * User: shyamlal
 * Problem Description
 * You have a string, denoted as A.
 * <p>
 * To transform the string, you should perform the following operation repeatedly:
 * Identify the first occurrence of consecutive identical pairs of characters within the string.
 * Remove this pair of identical characters from the string.
 * Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
 * The final result will be the transformed string.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the final string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abccbc"
 * Input 2:
 * <p>
 * A = "ab"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "ac"
 * Output 2:
 * <p>
 * "ab"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The Given string is "abccbc".
 * <p>
 * Remove the first occurrence of consecutive identical pairs of characters "cc".
 * After removing the string will be "abbc".
 * <p>
 * Again Removing the first occurrence of consecutive identical pairs of characters "bb".
 * After remvoing, the string will be "ac".
 * <p>
 * Now, there is no consecutive identical pairs of characters.
 * Therefore the string after this operation will be "ac".
 * Explanation 2:
 * <p>
 * No removals are to be done.
 */
public class DoubleCharacterTrouble {
    public static void main(String[] args) {
        System.out.println(solve("abccbc"));
    }

    public static String solve(String A) {
        int n = A.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.empty() || st.peek() != A.charAt(i)) {
                st.push(A.charAt(i));
            } else {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.empty()) {
            sb.append(st.peek());
            st.pop();
        }
        return sb.reverse().toString();
    }
}
