/**
 * Date: 15/01/2024:17:16
 * User: shyamlal
 * Problem Description
 * Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
 * <p>
 * You need to return the length of such longest common subsequence.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Length of A, B <= 1005
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is a string A.
 * Second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of the longest common subsequence.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abbcdgf"
 * B = "bbadcgf"
 * Input 2:
 * <p>
 * A = "aaaaaa"
 * B = "ababab"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The longest common subsequence is "bbcgf", which has a length of 5.
 * Explanation 2:
 * <p>
 * The longest common subsequence is "aaa", which has a length of 3.
 */
public class LongestCommonSequence {
    public int[][] dp;

    public static void main(String[] args) {
        LongestCommonSequence lcs = new LongestCommonSequence();
        System.out.println(lcs.solve("abbcdgf", "bbadcgf"));
    }

    public int LCS(String A, String B, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        // if dp[i][j]!=-1, then we already got the ans for the particular recursion, so we'll return dp[i][j].
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        //if both characters are equal then, we need to check the previous characters of both strings and add 1 to the ans.
        if (A.charAt(i) == B.charAt(j)) {
            ans = LCS(A, B, i - 1, j - 1) + 1;
        } else {
            //if both are not equal, then we have two possibilities
            // chech previous character of A String
            int a = LCS(A, B, i - 1, j);
            //and check previous character of B String .
            int b = LCS(A, B, i, j - 1);
            //Since we need to find the Max value, we'll consider max of both a and b.
            ans = Math.max(a, b);
            //we'll update the ans to the dp for future use.
            dp[i][j] = ans;
        }
        return ans;
    }

    public int solve(String A, String B) {
        int N = A.length();
        int M = A.length();
        // create an dp and fill it with -1.
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = LCS(A, B, N - 1, M - 1);
        return ans;
    }
}
