/**
 * Date: 15/01/2024:19:21
 * User: shyamlal
 * Problem Description
 * Say you have an array, A, for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Return the maximum possible profit.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A.size() <= 700000
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument is an array of integers, A.
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the maximum possible profit.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2]
 * Input 2:
 * <p>
 * A = [1, 4, 5, 2, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Buy the stock on day 0, and sell it on day 1.
 * Explanation 2:
 * <p>
 * Buy the stock on day 0, and sell it on day 2.
 */
public class BestTimeToSellStockI {
    public static void main(String[] args) {
        int[] A = {1, 4, 5, 2, 4};
        System.out.println(maxProfit(A));
    }

    public static int maxProfit(final int[] A) {
        int N = A.length;
        int maxprofit = 0;
        if (N == 0) {
            return 0;
        }
        int max = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            if (A[i] > max) {
                max = A[i];
            }
            int profit = max - A[i];
            if (profit > maxprofit) {
                maxprofit = profit;
            }
        }
        return maxprofit;
    }
}
