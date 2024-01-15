import java.util.Arrays;

/**
 * Date: 15/01/2024:17:36
 * User: shyamlal
 * Problem Description
 * Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
 * <p>
 * ' ? ' : Matches any single character.
 * ' * ' : Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A), length(B) <= 104
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a string A.
 * The second argument of input contains a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if the patterns match else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "aaa"
 * B = "a*"
 * Input 2:
 * <p>
 * A = "acz"
 * B = "a?a"
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
 * Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
 * So, the pattern matches we return 1.
 * Explanation 2:
 * <p>
 * '?' matches any single character. First two character in string A will be match.
 * But the last character i.e 'z' != 'a'. Return 0.
 */
public class RegularExpressionMatch {
    public static void main(String[] args) {
        RegularExpressionMatch rem = new RegularExpressionMatch();
        System.out.println(rem.isMatch("acz", "a?a"));
    }

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        StringBuilder sb = new StringBuilder();
        //removing extra char * if they are side by side in B to avoid java heap space issue for hard test case
        for (int i = 0; i < m - 1; i++) {
            if (B.charAt(i) == '*' && B.charAt(i + 1) == '*') continue;
            sb.append(B.charAt(i));
        }
        sb.append(B.charAt(m - 1));
        String s = sb.toString();
        m = s.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);

        return matching(A, s, n - 1, m - 1, dp);
    }

    public int matching(String A, String B, int i, int j, int[][] dp) {
        if (i < 0 && j < 0) return 1;
        //if still chars left in B
        if (i < 0) {
            while (j >= 0) {
                if (B.charAt(j) == '*') j--;
                else return 0;
            }
            return 1;
        }
        //if still chars left in A
        if (j < 0) return 0;

        if (dp[i][j] == -1) {
            //if chars are equal check the previous one.
            if (A.charAt(i) == B.charAt(j)) {
                dp[i][j] = matching(A, B, i - 1, j - 1, dp);
            }
            // Three possibilities if B char is *
            else if (B.charAt(j) == '*') {
                //while(j-1>=0 && (B.charAt(j)== '*' && B.charAt(j-1) =='*')) j--;
                dp[i][j] = (matching(A, B, i - 1, j - 1, dp) | matching(A, B, i - 1, j, dp)) | matching(A, B, i, j - 1, dp);
            }
            //Only one possibility if B char is ?
            else if (B.charAt(j) == '?') {
                dp[i][j] = matching(A, B, i - 1, j - 1, dp);
            }
            //if char are not equal return 0
            else {
                dp[i][j] = 0;
            }
        }
        return dp[i][j];
    }
}
