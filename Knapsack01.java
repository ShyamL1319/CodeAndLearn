import java.util.Arrays;

/**
 * Date: 14/01/2024:14:54
 * User: shyamlal
 * Problem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 * <p>
 * Also given an integer C which represents knapsack capacity.
 * <p>
 * Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * NOTE:
 * <p>
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 103
 * <p>
 * 1 <= C <= 103
 * <p>
 * 1 <= A[i], B[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 * <p>
 * Second argument is an integer array B of size N denoting the weights on N items.
 * <p>
 * Third argument is an integer C denoting the knapsack capacity.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [60, 100, 120]
 * B = [10, 20, 30]
 * C = 50
 * Input 2:
 * <p>
 * A = [10, 20, 30, 40]
 * B = [12, 13, 15, 19]
 * C = 10
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 220
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
 * Explanation 2:
 * <p>
 * Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
 */
public class Knapsack01 {
    public static int[][] dp;

    public static void main(String[] args) {
        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int[] A, int[] B, int C) {
        int n = A.length;
        dp = new int[n][C + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(A, B, n - 1, C);
    }

    public static int helper(int[] val, int[] wt, int i, int k) {
        if (i < 0 || k == 0) {
            return 0;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int a = 0;
        // check if we can make yes call or not
        if (k >= wt[i]) {
            a = helper(val, wt, i - 1, k - wt[i]) + val[i];
        }
        // no call
        int b = helper(val, wt, i - 1, k);

        int ans = Math.max(a, b);
        return dp[i][k] = ans;
    }
}
