import java.util.HashMap;

/**
 * Date: 14/12/2023:08:25
 * User: shyamlal
 * Problem Description
 * Given an array A of N integers.
 * Find the length of the longest subarray in the array which sums to zero.
 * <p>
 * If there is no subarray which sums to zero then return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * Single argument which is an integer array A.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, -2, 1, 2]
 * Input 2:
 * <p>
 * A = [3, 2, -1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * [1, -2, 1] is the largest subarray which sums up to 0.
 * Explanation 2:
 * <p>
 * No subarray sums up to 0.
 */
public class LongestZeroSumLength {
    public static void main(String[] args) {
        int[] A = {-1, 1, 2, 2, 1, -6, 5, 1, -3, 1, 2};
        System.out.println(longestZeroSumLength(A));
    }

    public static int longestZeroSumLength(int[] A) {
        int MOD = 1000000007;
        int N = A.length;
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum = (sum + A[j]) % MOD;
            if (sum == 0) {
                cnt = j + 1;
            }
            int sumLocation = hm.getOrDefault(sum, 0);
            if (sumLocation != 0) {
                cnt = Math.max(cnt, j - sumLocation);
            } else {
                hm.put(sum, j);
            }
        }
        return cnt;
    }
}
