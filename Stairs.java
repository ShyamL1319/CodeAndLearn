import java.util.Arrays;

/**
 * Date: 11/01/2024:08:15
 * User: shyamlal
 * Problem Description
 * You are climbing a staircase and it takes A steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Return the number of distinct ways modulo 1000000007
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains an integer A, the number of steps.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the number of ways to reach the top.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Distinct ways to reach top: [1, 1], [2].
 * Explanation 2:
 * <p>
 * Distinct ways to reach top: [1 1 1], [1 2], [2 1].
 */
public class Stairs {
    static int[] dp;
    static int mod;

    public static void main(String[] args) {
        System.out.println(climbStairs(2));

    }

    public static int rec(int A) {
        mod = 1000000007;
        if (A <= 2) {
            return A;
        }
        if (dp[A] == -1) {
            dp[A] = rec(A - 1) + rec(A - 2);
        }
        return dp[A] % mod;
    }

    public static int climbStairs(int A) {
        dp = new int[A + 1];
        Arrays.fill(dp, -1);
        return rec(A);


    }
}
