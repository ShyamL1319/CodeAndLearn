import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 08/01/2024:00:25
 * User: shyamlal
 * Problem Description
 * Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array,
 * leaving the other elements in the same relative order.
 * <p>
 * NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= B <= length of the array <= 500000
 * 1 <= A[i] <= 100000
 * <p>
 * <p>
 * Input Format
 * The argument given is the integer array A and an integer B.
 * <p>
 * <p>
 * Output Format
 * Return an array of integer after reversing the first B elements of A using queue.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [3, 2, 1, 4, 5]
 * Output 2:
 * <p>
 * [17, 5, 100, 11]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
 * Explanation 2:
 * <p>
 * Reverse first 2 elements so the array becomes [17, 5, 100, 11]
 */
public class ReversingElementsOfQueue {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] res = solve(A, 3);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int[] A, int B) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = B - 1; i >= 0; i--) {
            q.add(A[i]);
        }
        int[] ans = new int[A.length];
        for (int i = 0; i < B; i++) {
            ans[i] = q.poll();
        }
        if (A.length - B >= 0) System.arraycopy(A, B, ans, B, A.length - B);
        return ans;
    }
}
