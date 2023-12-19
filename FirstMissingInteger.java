/**
 * Date: 19/12/2023:09:26
 * User: shyamlal
 * roblem Description
 * Given an unsorted integer array, A of size N. Find the first missing positive integer.
 * <p>
 * Note: Your algorithm should run in O(n) time and use constant space.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the first missing positive integer.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * [1, 2, 0]
 * Input 2:
 * <p>
 * [3, 4, -1, 1]
 * Input 3:
 * <p>
 * [-8, -7, -6]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * Output 3:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A = [1, 2, 0]
 * First positive integer missing from the array is 3.
 * Explanation 2:
 * <p>
 * A = [3, 4, -1, 1]
 * First positive integer missing from the array is 2.
 * Explanation 3:
 * <p>
 * A = [-8, -7, -6]
 * First positive integer missing from the array is 1.
 */
public class FirstMissingInteger {
    public static void main(String[] args) {
        int[] A = {3, 4, -1, 1};

        System.out.println(firstMissingPositive(A));
    }

    public static int firstMissingPositive(int[] A) {

        int n = A.length;
        for (int i = 0; i < n; i++) {
            int k = A[i];
            while (k > 0 && k <= n && A[k - 1] != k) {
                A[i] = A[k - 1];
                A[k - 1] = k;
                k = A[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if (A[i] != (i + 1)) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
