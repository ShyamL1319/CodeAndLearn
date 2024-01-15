/**
 * Date: 15/01/2024:19:10
 * User: shyamlal
 * Problem Description
 * Given an array of integers A representing chain of 2-D matices such that the dimensions of ith matrix is A[i-1] x A[i].
 * <p>
 * Find the most efficient way to multiply these matrices together. The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.
 * <p>
 * Return the minimum number of multiplications needed to multiply the chain.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 1000
 * 1 <= A[i] <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of multiplications needed to multiply the chain.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [40, 20, 30, 10, 30]
 * Input 2:
 * <p>
 * A = [10, 20, 30]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 26000
 * Output 2:
 * <p>
 * 6000
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Dimensions of A1 = 40 x 20
 * Dimensions of A2 = 20 x 30
 * Dimensions of A3 = 30 x 10
 * Dimensions of A4 = 10 x 30
 * First, multiply A2 and A3 ,cost = 20*30*10 = 6000
 * Second, multilpy A1 and (Matrix obtained after multilying A2 and A3) =  40 * 20 * 10 = 8000
 * Third, multiply (Matrix obtained after multiplying A1, A2 and A3) and A4 =  40 * 10 * 30 = 12000
 * Total Cost = 12000 + 8000 + 6000 =26000
 * Explanation 2:
 * <p>
 * Cost to multiply two matrices with dimensions 10 x 20 and 20 x 30 = 10 * 20 * 30 = 6000.
 */
public class MatrixChainMultiplication {
    public static void main(String[] args) {
        int[] A = {40, 20, 30, 10, 30};
        MatrixChainMultiplication mcm = new MatrixChainMultiplication();
        System.out.println(mcm.solve(A));
    }

    public int solve(int[] A) {
        int N = A.length;
        int[][] dp = new int[N + 1][N + 1];
        return minCost(dp, 1, N - 1, A);
    }

    public int minCost(int[][] dp, int i, int j, int[] A) {
        //base case i and j equals there is no cost so return 0
        if (i == j) {
            return 0;
        }
        // if we are entering this subproblem for the first time
        if (dp[i][j] == 0) {
            dp[i][j] = Integer.MAX_VALUE;
            // iterate over possible partition points k
            for (int k = i; k < j; k++) {
                // recursively calculate the cost for left and right submatrices
                int cost = minCost(dp, i, k, A) + minCost(dp, k + 1, j, A) + A[i - 1] * A[k] * A[j];
                dp[i][j] = Math.min(dp[i][j], cost);
            }
        }
        // if we already have the minimum cost for this subproblem, return it
        return dp[i][j];
    }
}
