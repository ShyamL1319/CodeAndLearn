import java.util.Stack;

/**
 * Date: 07/01/2024:15:20
 * User: shyamlal
 * Problem Description
 * Given an array A, find the next greater element G[i] for every element A[i] in the array.
 * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
 * <p>
 * More formally:
 * <p>
 * G[i] for an element A[i] = an element A[j] such that
 * j is minimum possible AND
 * j > i AND
 * A[j] > A[i]
 * Elements for which no greater element exists, consider the next greater element as -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains the integer array, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array representing the next greater element for each index in A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 5, 2, 10]
 * Input 2:
 * <p>
 * A = [3, 2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [5, 10, 10, -1]
 * Output 2:
 * <p>
 * [-1, -1, -1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * For 4, the next greater element towards its right is 5.
 * For 5 and 2, the next greater element towards their right is 10.
 * For 10, there is no next greater element towards its right.
 * Explanation 2:
 * <p>
 * As the array is in descending order, there is no next greater element for all the elements.
 */
public class NextGreater {
    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        int[] res = nextGreater(A);

        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] nextGreater(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 0 && stk.peek() <= A[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                res[i] = stk.peek();
            } else {
                res[i] = -1;
            }
            stk.push(A[i]);
        }
        return res;
    }
}
