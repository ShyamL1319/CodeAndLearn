import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:12:26
 * User: shyamlal
 * Problem Description
 * Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
 * Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.
 * <p>
 * Find and return the array C.
 * <p>
 * NOTE:
 * <p>
 * If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
 * If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array C, C[i] denotes the median of the first i elements.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 5, 4, 3]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 1, 2, 2, 3]
 * Output 2:
 * <p>
 * [5, 5, 17, 11]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * stream          median
 * [1]             1
 * [1, 2]          1
 * [1, 2, 5]       2
 * [1, 2, 5, 4]    2
 * [1, 2, 5, 4, 3] 3
 * Explanation 2:
 * <p>
 * stream          median
 * [5]              5
 * [5, 17]          5
 * [5, 17, 100]     17
 * [5, 17, 100, 11] 11
 */
public class RunningMedian {
    public static void main(String[] args) {
        int[] A = {1, 2, 5, 4, 3};
        int[] res = solve(A);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int[] A) {
        PriorityQueue<Integer> lpq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rpq = new PriorityQueue<>();
        int[] arr = new int[A.length];
        lpq.add(A[0]);
        for (int i = 0; i < A.length; i++) {
            if (A[i] > lpq.peek()) {
                rpq.add(A[i]);
            }
            if (A[i] < lpq.peek()) {
                lpq.add(A[i]);
                rpq.add(lpq.remove());
            }
            if (rpq.size() > lpq.size()) {
                lpq.add(rpq.remove());
            }
            arr[i] = lpq.peek();

        }
        return arr;
    }
}
