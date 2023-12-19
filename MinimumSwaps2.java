/**
 * Date: 19/12/2023:08:56
 * User: shyamlal
 * Problem Description
 * Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
 * <p>
 * It is allowed to swap any two elements (not necessarily consecutive).
 * <p>
 * Find the minimum number of swaps required to sort the array in ascending order.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] < N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the minimum number of swaps.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 0]
 * Input 2:
 * <p>
 * A = [2, 0, 1, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There are many ways, to make the array sorted,
 * <p>
 * One of the sequence of swaps as follow:
 * Initial array   ->   [1, 2, 3, 4, 0]
 * swapping (1, 2) becomes [2, 1, 3, 4, 0]
 * swapping (2, 3) becomes [3, 1, 2, 4, 0]
 * swapping (4, 0) becomes [3, 1, 2, 0, 4]
 * swapping (3, 0) becomes [0, 1, 2, 3, 4].
 * Thus the array is sorted in 4 swaps.  It cannot be sorted inlesser than 4 swaps.
 * Explanation 2:
 * <p>
 * One of the sequence of swaps as follow:
 * Initial array  ->    [2, 0, 1, 3]
 * swapping (2, 0) becomes [0, 2, 1, 3]
 * swapping (1, 2) becomes [0, 1, 2, 3].
 * <p>
 * Thus the array is sorted in 2 swaps. It cannot be sorted in lesser than 4 swaps.
 */
public class MinimumSwaps2 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 0};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int count = 0;
        int i = 0;
        while (i < A.length) {
            if (A[i] == i) i++;
            else {
                count++;
                int temp = A[i];
                A[i] = A[temp];
                A[temp] = temp;
            }
        }
        return count;
    }
}
