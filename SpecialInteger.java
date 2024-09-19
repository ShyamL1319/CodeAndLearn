/**
 * Date: 25/12/2023:05:42
 * User: shyamlal
 * Problem Description
 * Given an array of integers A and an integer B, find and return the maximum value K such that there is no subarray in A of size K with the sum of elements greater than B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the maximum value of K (sub array length).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 10
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 130
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
 * For K = 5, There are subarrays [1, 2, 3, 4, 5] which has a sum > B
 * For K = 4, There are subarrays [1, 2, 3, 4], [2, 3, 4, 5] which has a sum > B
 * For K = 3, There is a subarray [3, 4, 5] which has a sum > B
 * For K = 2, There were no subarray which has a sum > B.
 * Constraints are satisfied for maximal value of 2.
 * Explanation 2:
 * <p>
 * For K = 4, There are subarrays [5, 17, 100, 11] which has a sum > B
 * For K = 3, There were no subarray which has a sum > B.
 * Constraints are satisfied for maximal value of 3.
 */
public class SpecialInteger {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 10;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        int n = A.length;
        int l = 0;
        int r = n;
        int ans = l;

        while (l <= r) {
            int m = (r + l) / 2;
            if (check(m, A, B, n)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return ans;
    }

    public static boolean check(int m, int[] A, int B, int n) {
        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum = sum + A[i];
        }

        if (sum > B) {
            return false;
        }

        int start = 1;
        int end = m;
        while (end < n) {
            sum = sum - A[start - 1] + A[end];
            if (sum > B) {
                return false;
            }
            start++;
            end++;
        }

        return true;
    }
}
