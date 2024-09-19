/**
 * Date: 20/12/2023:07:55
 * User: shyamlal
 * Problem Description
 * Given a sorted array of integers A where every element appears twice except for one element which appears once, find and return this single element that appears only once.
 * <p>
 * Elements which are appearing twice are adjacent to each other.
 * <p>
 * NOTE: Users are expected to solve this in O(log(N)) time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the single element that appears only once.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 7]
 * Input 2:
 * <p>
 * A = [2, 3, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 7
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 7 appears once
 * Explanation 2:
 * <p>
 * 2 appears once
 */
public class SingleElementInSortedArr {
    public static void main(String[] args) {
        int[] A = {7, 8, 8};

        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int n = A.length;
        int l = 1;
        int h = n - 2;

        if (n == 1) {
            return A[0];
        }

        if (A[0] != A[1]) {
            return A[0];
        }
        if (A[n - 1] != A[n - 2]) {
            return A[n - 1];
        }

        while (l <= h) {
            int m = (l + h) / 2;
            if (A[m] != A[m - 1] && A[m] != A[m + 1]) {
                return A[m];
            }

            if (A[m] == A[m - 1]) {
                m = m - 1;
            }

            if (m % 2 == 0) {
                l = m + 2;
            } else {
                h = m - 1;
            }

        }
        return -1;
    }
}
