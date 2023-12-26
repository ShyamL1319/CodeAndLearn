/**
 * Date: 26/12/2023:07:41
 * User: shyamlal
 * Problem Description
 * <p>
 * Given two strings - a text A and a pattern B, having lower-case alphabetic characters. You have to determine the number of occurrences of pattern B in text A as its substring. i.e. the number of times B occurs as a substring in A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= |B| <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is a string A
 * <p>
 * Second argument is a string B
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the number of occurrences.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = "abababa"
 * B = "aba"
 * Input 2:
 * <p>
 * A = "mississipi"
 * B = "ss"
 * Input 3:
 * <p>
 * A = "hello"
 * B = "hi"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * Output 3:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A has 3 substrings equal to B - A[1, 3], A[3, 5] and A[5, 7]
 * Explanation 2:
 * <p>
 * B occurs two times in A - A[3, 4], A[6, 7].
 * Explanation 3:
 * <p>
 * B does not occur in A as a substring.
 */
public class KMPHiddenPattern {
    public static void main(String[] args) {
        String A = "abababa";
        String B = "aba";
        System.out.println(solve(A, B));
    }

    public static int[] lps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        for (int i = 1; i < n; i++) {
            int x = lps[i - 1];
            while (s.charAt(i) != s.charAt(x)) {
                if (x == 0) {
                    x = -1;
                    break;
                }
                x = lps[x - 1];
            }
            lps[i] = x + 1;
        }
        return lps;
    }

    public static int solve(final String A, final String B) {
        if (B.length() > A.length()) {
            return 0;
        }
        String str = B + "#" + A;
        int[] lps = lps(str);
        int ans = 0;
        for (int i = 0; i < lps.length; i++) {
            if (lps[i] == B.length()) {
                ans++;
            }
        }
        return ans;
    }
}
