import java.util.Arrays;

/**
 * Date: 15/01/2024:19:29
 * User: shyamlal
 * Problem Description
 * Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
 * <p>
 * Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000
 * <p>
 * 0 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 4, 1, 6, 2]
 * Input 2:
 * <p>
 * A = [1, 5, 2, 5, 6]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 15
 * Output 2:
 * <p>
 * 11
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
 * Explanation 2:
 * <p>
 * Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.
 */
public class CutARod {
    static int[][] dp;

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 6, 2};
        System.out.println(solve(A));
    }

    public static int solve2(int[] A) {
        int n = A.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = A[i - 1];
            for (int j = 1; j <= (i + 1) / 2; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
            }
        }

        return dp[n];
    }

    public static int solve(int[] A) {
        int N = A.length;
        dp = new int[N + 1][N + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        //we have 0 based indexing in the array we need to adjust this in statements of resolve function
        //to deduct the appropriate length from the size of the rod.
        return resolve(A, 0, N);
    }

    public static int resolve(int[] A, int i, int size) {
        //if rod size becomes 0 we cant cut further.
        if (size == 0) {
            return 0;
        }
        //we cant cut a piece lager than the size of the rod;
        if (i >= size) {
            return 0;
        }
        if (dp[i][size] != -1) {
            return dp[i][size];
        }
        //Either we cut the piece of length i from the rod or either we not and move to next value of i.
        dp[i][size] = Math.max(A[i] + resolve(A, i, size - (i + 1)), resolve(A, i + 1, size));
        return dp[i][size];
    }
}
