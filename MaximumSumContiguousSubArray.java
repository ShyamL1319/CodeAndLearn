/**
 * Date: 18/12/2023:09:29
 * User: shyamlal
 * Problem Description
 * Find the maximum sum of contiguous non-empty subarray within an array A of length N.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1e6
 * -1000 <= A[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains an integer array, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer representing the maximum possible sum of the contiguous subarray.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, -10]
 * Input 2:
 * <p>
 * A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The subarray [1, 2, 3, 4] has the maximum possible sum of 10.
 * Explanation 2:
 * <p>
 * The subarray [4,-1,2,1] has the maximum possible sum of 6.
 */
public class MaximumSumContiguousSubArray {
    public static void main(String[] args) {
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxsum(A));
    }

    public static int maxsum(int[] A) {
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            answer = Math.max(answer, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return answer;
    }
}
