/**
 * Date: 11/01/2024:08:24
 * User: shyamlal
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum count.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 6
 * Input 2:
 * <p>
 * A = 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 * Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 * <p>
 * We can represent 5 using only 2 numbers i.e. 12 + 22 = 5
 */
public class MinimumNumberOfSquares {
    public static void main(String[] args) {

    }

    public static int minsqrt(int A, int[] DP) {
        if (A == 0 || A == 1) {
            return A;
        }
        if (DP[A] != 1) {
            return DP[A];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= A; i++) {
            int small = minsqrt((A - (i * i)), DP);
            min = Math.min(small, min);
        }
        DP[A] = min + 1;
        return min + 1;
    }

    public static int countMinSquares(int A) {
        int[] DP = new int[A + 1];
        for (int i = 0; i < A + 1; i++) {
            DP[i] = 1;
        }
        minsqrt(A, DP);
        return DP[A];
    }
}
