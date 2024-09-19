/**
 * Date: 14/01/2024:15:38
 * User: shyamlal
 * Problem Description
 * <p>
 * You are trying to send signals to aliens using a linear array of A laser lights. You don't know much about how the aliens are going to percieve the signals, but what you know is that if two consecutive lights are on then the aliens might take it as a sign of danger and destroy the earth.
 * <p>
 * Find and return the total number of ways in which you can send a signal without compromising the safty of the earth. Return the ans % 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the ans%(109+7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * OFF OFF
 * OFF ON
 * ON OFF
 * All lights off is also a valid signal which probably means 'bye'
 * <p>
 * Explanation 2:
 * <p>
 * OFF OFF OFF
 * OFF OFF ON
 * OFF ON OFF
 * ON OFF OFF
 * ON OFF ON
 */
public class WaysToSendSignal {
    public static void main(String[] args) {
        System.out.println(solve(2));
    }

    public static int solve(int A) {

        int[] dp = new int[A + 1];
        int MOD = 1000000007;

        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i <= A; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        return dp[A];
    }
}
