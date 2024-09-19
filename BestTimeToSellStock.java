import java.util.Arrays;

/**
 * Date: 15/01/2024:19:17
 * User: shyamlal
 * Problem Description
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit.
 * <p>
 * You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= len(A) <= 1e5
 * 1 <= A[i] <= 1e7
 * <p>
 * <p>
 * Input Format
 * The first and the only argument is an array of integer, A.
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the maximum possible profit.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 10]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 8
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * => Buy a stock on day 0.
 * => Sell the stock on day 1. (Profit +1)
 * => Buy a stock on day 1.
 * => Sell the stock on day 2. (Profit +1)
 * <p>
 * Overall profit = 2
 * Explanation 2:
 * => Buy a stock on day 1.
 * => Sell the stock on on day 2. (Profit +8)
 * <p>
 * Overall profit = 8
 */
public class BestTimeToSellStock {
    int[][] dp;

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        BestTimeToSellStock bts = new BestTimeToSellStock();
        System.out.println(bts.maxProfit(A));
    }

    public int checkProfit(int[] A, int n, int index, int buy) {
        if (index == n) {
            return 0;
        }

        if (dp[index][buy] != -1) {
            return dp[index][buy];
        }

        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-A[index] + checkProfit(A, n, index + 1, 0), checkProfit(A, n, index + 1, 1));
        } else {
            profit = Math.max(A[index] + checkProfit(A, n, index + 1, 1), checkProfit(A, n, index + 1, 0));
        }
        dp[index][buy] = profit;
        return profit;
    }

    public int maxProfit(final int[] A) {
        int n = A.length;
        dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return checkProfit(A, n, 0, 1);
    }
}
