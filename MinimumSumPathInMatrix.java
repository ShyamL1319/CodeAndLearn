import java.util.Arrays;

/**
 * Date: 14/01/2024:00:13
 * User: shyamlal
 * Problem Description
 * Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Return the minimum sum of the path.
 * <p>
 * NOTE: You can only move either down or right at any point in time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= M, N <= 2000
 * <p>
 * -1000 <= A[i][j] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a 2-D grid A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum sum of the path.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [1, 3, 2]
 * [4, 3, 1]
 * [5, 6, 1]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, -3, 2]
 * [2, 5, 10]
 * [5, -5, 1]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 8
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The path will be: 1 -> 3 -> 2 -> 1 -> 1.
 * Input 2:
 * <p>
 * The path will be: 1 -> -3 -> 5 -> -5 -> 1.
 */
public class MinimumSumPathInMatrix {
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 3, 1},
                {5, 6, 1}
        };
        System.out.println(minPathSum(A));
    }

    public static int minPathSum(int[][] A) {
        arr = A;

        int n = A.length;
        int m = A[0].length;

        if (n == 1 && m == 1) {
            return A[0][0];
        }

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return sum(n - 1, m - 1);
    }

    public static int sum(int i, int j) {
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (i == 0 && j == 0) {
            return arr[0][0];
        }

        if (dp[i][j] == -1) {
            dp[i][j] = Math.min(sum(i, j - 1), sum(i - 1, j)) + arr[i][j];
        }

        return dp[i][j];
    }
}
