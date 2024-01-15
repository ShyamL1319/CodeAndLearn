/**
 * Date: 15/01/2024:19:35
 * User: shyamlal
 * Problem Description
 * Given a string A, partition A such that every substring of the partition is a palindrome.
 * <p>
 * Return the minimum cuts needed for a palindrome partitioning of A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A) <= 501
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains the string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the minimum cuts needed.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "aba"
 * Input 2:
 * <p>
 * A = "aab"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * "aba" is already a palindrome, so no cuts are needed.
 * Explanation 2:
 * <p>
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(minCut("aba"));
    }

    private static void makePalendrome(String A, int[][] dp) {
        for (int d = 0; d < A.length(); d++) {
            for (int i = 0, j = d; j < A.length(); i++, j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    if (A.charAt(i) == A.charAt(j)) {
                        int left = i + 1;
                        int right = j - 1;
                        if (right < left) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = dp[left][right];
                        }
                    }
                }
            }
        }
    }

    public static int minCut(String A) {
        int[] dp = new int[A.length()];
        int[][] dpStore = new int[A.length()][A.length()];
        makePalendrome(A, dpStore);
        for (int i = 0; i < A.length(); i++) {
            dp[i] = i;
            if (dpStore[0][i] == 1) {
                dp[i] = 0;
            } else {
                for (int j = i; j >= 1; j--) {
                    if (dpStore[j][i] == 1) {
                        dp[i] = Math.min(dp[i], (dp[j - 1] + 1));
                    }
                }
            }
        }

        return dp[A.length() - 1];

    }
}
