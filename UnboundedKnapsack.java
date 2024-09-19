import java.util.Arrays;

/**
 * Date: 14/01/2024:15:11
 * User: shyamlal
 * Problem Description
 * Given a knapsack weight A and a set of items with certain value B[i] and weight C[i], we need to calculate maximum amount that could fit in this quantity.
 * <p>
 * This is different from classical Knapsack problem, here we are allowed to use unlimited number of instances of an item.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 1000
 * <p>
 * 1 <= |B| <= 1000
 * <p>
 * 1 <= B[i] <= 1000
 * <p>
 * 1 <= C[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is the Weight of knapsack A
 * <p>
 * Second argument is the vector of values B
 * <p>
 * Third argument is the vector of weights C
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the maximum value that fills the knapsack completely
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 10
 * B = [5]
 * C = [10]
 * Input 2:
 * <p>
 * A = 10
 * B = [6, 7]
 * C = [5, 5]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 14
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Only valid possibility is to take the given item.
 * Explanation 2:
 * <p>
 * Take the second item twice.
 */
public class UnboundedKnapsack {
    public static int[][] dp;

    public static void main(String[] args) {
        int[] B = {5};
        int[] C = {10};
        int A = 10;
        System.out.println(solve(A, B, C));
    }

    public static int solve(int A, int[] B, int[] C) {
        int n = B.length;
        dp = new int[n][A + 1];
        // filling a dp array value '-1'
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return helper(C, B, n - 1, A);
    }

    public static int helper(int[] wt, int[] val, int i, int k) {
        if (i < 0 || k == 0) {
            return 0;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int a = 0;
        // check if we can make yes call or not
        if (k >= wt[i]) {
            // if mainly yes call, go for same item on next level
            a = helper(wt, val, i, k - wt[i]) + val[i];
        }

        int b = helper(wt, val, i - 1, k);

        int ans = Math.max(a, b);

        return dp[i][k] = ans;
    }
}
