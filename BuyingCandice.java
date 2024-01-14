import java.util.Arrays;

/**
 * Date: 14/01/2024:15:29
 * User: shyamlal
 * Problem Description
 * Rishik likes candies a lot. So, he went to a candy-shop to buy candies.
 * <p>
 * The shopkeeper showed him N packets each containg A[i] candies for cost of C[i] nibbles, each candy in that packet has a sweetness B[i]. The shopkeeper puts the condition that Rishik can buy as many complete candy-packets as he wants but he can't buy a part of the packet.
 * <p>
 * Rishik has D nibbles, can you tell him the maximum amount of sweetness he can get from candy-packets he will buy?
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 700
 * <p>
 * 1 <= A[i] <= 1000
 * <p>
 * 1 <= B[i] <= 1000
 * <p>
 * 1 <= C[i],D <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument of input is an integer array A
 * Second argument of input is an integer array B
 * Third argument of input is an integer array C
 * Fourth argument of input is an integer D
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting maximum sweetness of the candies that he can buy
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3]
 * B = [2, 2, 10]
 * C = [2, 3, 9]
 * D = 8
 * Input 2:
 * <p>
 * A = [2]
 * B = [5]
 * C = [10]
 * D = 99
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 90
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Choose 1 Packet of kind 1 = 1 Candy of 2 Sweetness = 2 Sweetness
 * Choose 2 Packet of kind 2 = 2 Candy of 2 Sweetness = 8 Sweetness
 * Explanation 2:
 * <p>
 * Buy 9 Packet of kind 1. 18 Candy each of 5 Sweetness = 90 Sweetness
 */
public class BuyingCandice {
    int[][] dp;

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] B = {2, 2, 10};
        int[] C = {2, 3, 9};

        int D = 8;
        BuyingCandice fk = new BuyingCandice();
        System.out.println(fk.solve(A, B, C, D));
    }

    public int helper(int[] candy, int[] sweetness, int[] cost, int i, int cap) {
        if (i < 0 || cap == 0) {
            return 0;
        }

        if (dp[i][cap] != -1) {
            return dp[i][cap];
        }

        int a = 0;
        if (cap >= cost[i]) {
            a = helper(candy, sweetness, cost, i, cap - cost[i]) + sweetness[i];
        }
        int b = helper(candy, sweetness, cost, i - 1, cap);

        int ans = Math.max(a, b);
        dp[i][cap] = ans;

        return ans;
    }

    public int solve(int[] A, int[] B, int[] C, int D) {
        int n = B.length;
        dp = new int[n][D + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        for (int i = 0; i < n; i++) {
            B[i] = A[i] * B[i];
        }

        return helper(A, B, C, n - 1, D);
    }
}
