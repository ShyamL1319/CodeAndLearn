import java.util.Deque;
import java.util.LinkedList;

/**
 * Date: 08/01/2024:07:55
 * User: shyamlal
 * Problem Description
 * Given an array A of both positive and negative integers.
 * <p>
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 * <p>
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of array A <= 105
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * 1 <= B <= size of array
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument denotes the integer array A.
 * The second argument denotes the value B
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer that denotes the required value.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 5, -1, 7, -3, -1, -2]
 * B = 4
 * Input 2:
 * <p>
 * A = [2, -1, 3]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 18
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Subarrays of size 4 are :
 * [2, 5, -1, 7],   min + max = -1 + 7 = 6
 * [5, -1, 7, -3],  min + max = -3 + 7 = 4
 * [-1, 7, -3, -1], min + max = -3 + 7 = 4
 * [7, -3, -1, -2], min + max = -3 + 7 = 4
 * Sum of all min & max = 6 + 4 + 4 + 4 = 18
 * Explanation 2:
 * <p>
 * Subarrays of size 2 are :
 * [2, -1],   min + max = -1 + 2 = 1
 * [-1, 3],   min + max = -1 + 3 = 2
 * Sum of all min & max = 1 + 2 = 3
 */
public class SumOfMinMax {
    public static void main(String[] args) {
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        System.out.println(solve(A, 4));
    }

    public static int solve(int[] A, int B) {
        long sum = slidingMaxMinSum(A, B);
        return (int) (((sum) % 1000000007) + 1000000007) % 1000000007;
    }

    public static long slidingMaxMinSum(final int[] A, int B) {
        Deque<Integer> dqueMax = new LinkedList();
        Deque<Integer> dqueMin = new LinkedList();
        int n = A.length;
        long ans = 0;
        for (int i = 0; i < B; i++) {
            while (!dqueMax.isEmpty() && A[i] >= A[dqueMax.peekLast()]) {
                dqueMax.pollLast();
            }
            dqueMax.offerLast(i);
            while (!dqueMin.isEmpty() && A[i] <= A[dqueMin.peekLast()]) {
                dqueMin.pollLast();
            }
            dqueMin.offerLast(i);
        }
        ans = A[dqueMax.peekFirst()] + A[dqueMin.peekFirst()];
        int l = 1;
        int r = B;
        while (r < n) {
            if (l - 1 == dqueMax.peekFirst()) {
                dqueMax.pollFirst();
            }
            while (!dqueMax.isEmpty() && A[r] >= A[dqueMax.peekLast()]) {
                dqueMax.pollLast();
            }
            dqueMax.offerLast(r);
            if (l - 1 == dqueMin.peekFirst()) {
                dqueMin.pollFirst();
            }
            while (!dqueMin.isEmpty() && A[r] <= A[dqueMin.peekLast()]) {
                dqueMin.pollLast();
            }
            dqueMin.offerLast(r);
            ans = (ans + A[dqueMax.peekFirst()] + A[dqueMin.peekFirst()]);
            l++;
            r++;

        }
        return ans;
    }
}
