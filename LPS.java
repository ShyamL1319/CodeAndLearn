/**
 * Date: 15/01/2024:17:23
 * User: shyamlal
 * Problem Description
 * Given a string A. Find the longest palindromic subsequence (A subsequence which does not need to be contiguous and is a palindrome).
 * <p>
 * You need to return the length of longest palindromic subsequence.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of(A) <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only integer is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of longest palindromic subsequence.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "bebeeed"
 * Input 2:
 * <p>
 * A = "aedsead"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The longest palindromic subsequence is "eeee", which has a length of 4.
 * Explanation 2:
 * <p>
 * The longest palindromic subsequence is "aedea", which has a length of 5.
 */
public class LPS {
    public static void main(String[] args) {
        LPS lps = new LPS();
        System.out.println(lps.solve("bebeeed"));
    }

    public int longestPalindromic(String A, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] == -1) {
            if (A.charAt(i) == A.charAt(j)) {
                dp[i][j] = 2 + longestPalindromic(A, i + 1, j - 1, dp);
            } else {
                dp[i][j] = Math.max(longestPalindromic(A, i + 1, j, dp), longestPalindromic(A, i, j - 1, dp));
            }
        }
        return dp[i][j];

    }

    public int solve(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return longestPalindromic(A, 0, n - 1, dp);
    }
}
