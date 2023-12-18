/**
 * Date: 18/12/2023:09:23
 * User: shyamlal
 * Problem Description
 * Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is the vector A
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return one integer, the answer to the question
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [0, 1, 0, 2]
 * Input 2:
 * <p>
 * A = [1, 2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1 unit is trapped on top of the 3rd element.
 * Explanation 2:
 * <p>
 * No water is trapped.
 */
public class RainTrappedWater {
    public static void main(String[] args) {
        int[] A = {0, 1, 0, 2};
        System.out.println(trappedWater(A));
    }

    public static int trappedWater(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int ans = 0;
        //populate left and right arrays
        left[0] = A[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], A[i]);
        }
        right[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], A[i]);
        }
        //to calculate water traped in each index
        for (int i = 0; i < n; i++) {
            ans += (Math.min(left[i], right[i]) - A[i]);
        }
        return ans;
    }
}
