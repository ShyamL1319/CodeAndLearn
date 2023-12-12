import java.util.HashMap;

/**
 * Date: 12/12/2023:09:27
 * User: shyamlal
 * Problem Description
 * Given an array A of N integers.
 * <p>
 * Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7
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
 * A = [1, -1, -2, 2]
 * Input 2:
 * <p>
 * A = [-1, 2, -1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
 * Explanation 2:
 * <p>
 * The subarray with zero sum is [-1, 2, -1].
 */
public class CountSubArrayZeroSum {
    public static void main(String[] args) {
        int[] A = {1, -1, -2, 2};
        System.out.println(countZeroSum(A));
    }

    public static int countZeroSum(int[] A) {
        int MOD = 1000000007;
        int N = A.length;
        int cnt = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum = (sum + A[j]) % MOD;
            if (hm.containsKey(sum)) {
                cnt += hm.put(sum, hm.get(sum) + 1);
            } else {
                hm.put(sum, 1);
            }
        }
        cnt += hm.getOrDefault(0, 0);
        return cnt;
    }
}
