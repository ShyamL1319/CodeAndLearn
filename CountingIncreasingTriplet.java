/**
 * Problem Description
 * You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k]
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 103
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 4, 3]
 * Input 2:
 * A = [2, 1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 2
 * Output 2:
 * 1
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * The triplets that satisfy the conditions are [1, 2, 3] and [1, 2, 4].
 * For Input 2:
 * <p>
 * The triplet that satisfy the conditions is [1, 2, 3].
 */

public class CountingIncreasingTriplet {
    public static void main(String[] args) {
        int[] A = {1, 2, 4, 3};
        System.out.println(countIncreasingTriplet(A));
    }

    public static int countIncreasingTriplet(int[] A) {
        int ans = 0;
        int N = A.length;
        for (int j = 1; j < N - 1; j++) {
            int lk = 0;
            int rk = 0;
            for (int k = j - 1; k >= 0; k--) {
                if (A[k] < A[j]) lk++;
            }

            for (int k = j + 1; k < N; k++) {
                if (A[k] > A[j]) rk++;
            }

            ans += (lk * rk);
        }

        return ans;
    }
}
