import java.util.Arrays;

/**
 * Date: 15/01/2024:19:04
 * User: shyamlal
 * Problem Description
 * Find the longest increasing subsequence of a given array of integers, A.
 * <p>
 * In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
 * <p>
 * In this case, return the length of the longest increasing subsequence.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A) <= 2500
 * 0 <= A[i] <= 2500
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer representing the length of the longest increasing subsequence.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 1, 5]
 * Input 2:
 * <p>
 * A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The longest increasing subsequence: [1, 2, 5]
 * Explanation 2:
 * <p>
 * The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] A = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(lis(A));
    }

    public static int lis(final int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        return dp[n - 1];
    }
}
