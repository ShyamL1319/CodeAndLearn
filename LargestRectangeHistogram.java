import java.util.Stack;

/**
 * Date: 07/01/2024:15:15
 * User: shyamlal
 * Problem Description
 * Given an array of integers A.
 * <p>
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 * <p>
 * Find the area of the largest rectangle formed by the histogram.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 * <p>
 * A = [2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 * <p>
 * Largest rectangle has area 2.
 */
public class LargestRectangeHistogram {
    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(A));
    }

    public static int largestRectangleArea(int[] A) {
        int n = A.length;
        int[] nearestLeft = smallerLeftIndex(A);

        int[] nearestRight = smallerRightIndex(A);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int h = A[i];
            int s = nearestLeft[i], e = nearestRight[i];
            int W = e - s - 1;
            int area = h * W;
            max = Math.max(max, area);
        }
        return max;
    }

    public static int[] smallerLeftIndex(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (stk.size() > 0 && A[stk.peek()] >= A[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                res[i] = stk.peek();
            } else {
                res[i] = -1;
            }
            stk.push(i);
        }
        return res;
    }

    public static int[] smallerRightIndex(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 0 && A[stk.peek()] >= A[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                res[i] = stk.peek();
            } else {
                res[i] = n;
            }
            stk.push(i);
        }
        return res;
    }
}
