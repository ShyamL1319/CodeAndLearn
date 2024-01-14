import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:13:05
 * User: shyamlal
 * Problem Description
 * Given an integer array B of size N.
 * <p>
 * You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].
 * <p>
 * NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 1 <= A <= N
 * 1 <= B[i] <= INT_MAX
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer A.
 * The second argument is an integer array B of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array C, where C[i] (1 <= i <= N) will have the Ath largest element in the subarray [1 : i].
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 4
 * B = [1 2 3 4 5 6]
 * Input 2:
 * <p>
 * A = 2
 * B = [15, 20, 99, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [-1, -1, -1, 1, 2, 3]
 * Output 2:
 * <p>
 * [-1, 15, 20, 20]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * for i <= 3 output should be -1.
 * for i = 4, Subarray [1:4] has 4 elements 1, 2, 3 and 4. So, 4th maximum element is 1.
 * for i = 5, Subarray [1:5] has 5 elements 1, 2, 3, 4 and 5. So, 4th maximum element is 2.
 * for i = 6, Subarray [1:6] has 6 elements 1, 2, 3, 4, 5 and 6. So, 4th maximum element is 3.
 * So, output array is [-1, -1, -1, 1, 2, 3].
 * <p>
 * Explanation 2:
 * <p>
 * for i <= 1 output should be -1.
 * for i = 2 , Subarray [1:2] has 2 elements 15 and 20. So, 2th maximum element is 15.
 * for i = 3 , Subarray [1:3] has 3 elements 15, 20 and 99. So, 2th maximum element is 20.
 * for i = 4 , Subarray [1:4] has 4 elements 15, 20, 99 and 1. So, 2th maximum element is 20.
 * So, output array is [-1, 15, 20, 20].
 */
public class AthLargestElement {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 4;
        int[] res = solve(B, A);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int A, int[] B) {
        int n = B.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] result = new int[n];

        for (int i = 0; i < A; i++) {
            pq.add(B[i]);
            if (pq.size() < A) {
                result[i] = -1;
            } else {
                result[i] = pq.peek();
            }
        }
        for (int i = A; i < n; i++) {

            if (pq.peek() < B[i]) {
                pq.remove();
                pq.add(B[i]);
            }

            result[i] = pq.peek();

        }
        return result;
    }
}
