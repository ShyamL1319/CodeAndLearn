/**
 * Problem Description
 * Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
 * 1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
 * 2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
 * Your task is to find the count of good subarrays in A.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= len(A) <= 5 x 103
 * 1 <= A[i] <= 103
 * 1 <= B <= 107
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 * <p>
 * <p>
 * Output Format
 * Return the count of good subarrays in A.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 4
 * Input 2:
 * <p>
 * A = [13, 16, 16, 15, 9, 16, 2, 7, 6, 17, 3, 9]
 * B = 65
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 6
 * Output 2:
 * <p>
 * 36
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Even length good subarrays = {1, 2}
 * Odd length good subarrays = {1, 2, 3}, {1, 2, 3, 4, 5}, {2, 3, 4}, {3, 4, 5}, {5}
 * Explanation 1:
 * There are 36 good subarrays
 */
public class GoodSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int B = 4;
        System.out.println(goodSubArrays(arr, 4));
    }


    public static int goodSubArrays(int[] A, int B) {
        int N = A.length;
        for (int i = 1; i < N; i++) A[i] = A[i - 1] + A[i];
        int sum = 0;
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int len = j - i + 1;
                if (i != 0) {
                    sum = A[j] - A[i - 1];
                } else sum = A[j];
                if ((len % 2 == 0 & sum < B) | (len % 2 != 0 & sum > B)) count++;
            }
        }
        return count;
    }
}
