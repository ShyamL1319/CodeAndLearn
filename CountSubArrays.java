/**
 * Problem Description
 * Given an array A of N non-negative numbers and a non-negative number B,
 * you need to find the number of subarrays in A with a sum less than B.
 * We may assume that there is no overflow.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 5 x 103
 * <p>
 * 1 <= A[i] <= 1000
 * <p>
 * 1 <= B <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the number of subarrays in A having sum less than B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 5, 6]
 * B = 10
 * Input 2:
 * <p>
 * A = [1, 11, 2, 3, 15]
 * B = 10
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
 * Explanation 2:
 * <p>
 * The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */
public class CountSubArrays {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6};
        int B = 10;
        System.out.println(countSubArrays(arr, B));

    }

    public static int countSubArrays(int[] A, int B) {
        int N = A.length;
        for (int i = 1; i < N; i++) {
            A[i] = A[i - 1] + A[i];
        }
        int count = 0, sum;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (i != 0) {
                    sum = A[j] - A[i - 1];
                } else {
                    sum = A[j];
                }
                if (sum < B) count += 1;
                else break;
            }
        }
        return count;
    }
}
