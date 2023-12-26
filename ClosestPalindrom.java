/**
 * Date: 26/12/2023:07:47
 * User: shyamlal
 * Problem Description
 * Groot has a profound love for palindrome which is why he keeps fooling around with strings.
 * A palindrome string is one that reads the same backward as well as forward.
 * <p>
 * Given a string A of size N consisting of lowercase alphabets, he wants to know if it is possible to make the given string a palindrome by changing exactly one of its character.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the string YES if it is possible to make the given string a palindrome by changing exactly 1 character. Else, it should return the string NO.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abbba"
 * Input 2:
 * <p>
 * A = "adaddb"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "YES"
 * Output 2:
 * <p>
 * "NO"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * We can change the character at index 3(1-based) to any other character. The string will be palindromic.
 * Explanation 2:
 * <p>
 * To make the string palindromic we need to change 2 characters.
 */
public class ClosestPalindrom {
    public static void main(String[] args) {
        String A = "abbba";
        System.out.println(solve(A));
    }

    public static String solve(String A) {
        int start = 0;
        int end = A.length() - 1;
        int count = 0;
        while (start < end) {
            if (A.charAt(start) != A.charAt(end)) {
                count++;
                if (count == 2) return "NO";
            }
            start++;
            end--;
        }
        if (count == 0 && A.length() % 2 == 0) return "NO";
        return "YES";
    }
}
