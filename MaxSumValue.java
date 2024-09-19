/**
 * Date: 11/01/2024:08:37
 * User: shyamlal
 * Problem Description
 * <p>
 * You are given an array A of N integers and three integers B, C, and D.
 * <p>
 * You have to find the maximum value of A[i]*B + A[j]*C + A[k]*D, where 1 <= i <= j <= k <= N.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= N <= 105
 * <p>
 * -10000 <= A[i], B, C, D <= 10000
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an array A
 * Second argument is an integer B
 * Third argument is an integer C
 * Fourth argument is an integer D
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an Integer S, i.e maximum value of (A[i] * B + A[j] * C + A[k] * D), where 1 <= i <= j <= k <= N.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 5, -3, 4, -2]
 * B = 2
 * C = 1
 * D = -1
 * Input 2:
 * <p>
 * A = [3, 2, 1]
 * B = 1
 * C = -10
 * D = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 18
 * Output 2:
 * <p>
 * -4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * If you choose i = 2, j = 2, and k = 3 then we will get
 * A[2]*B + A[2]*C + A[3]*D = 5*2 + 5*1 + (-3)*(-1) = 10 + 5 + 3 = 18
 * Explanation 2:
 * <p>
 * If you choose i = 1, j = 3, and k = 3 then we will get
 * A[1]*B + A[3]*C + A[3]*D = (3*1) + (-10*1) + (3*1) = 3 - 10 + 3 = -4
 */
public class MaxSumValue {
    public static void main(String[] args) {
        int[] A = {1, 5, -3, 4, -2};
        System.out.println(solve(A, 2, 1, -1));
    }

    public static int solve(int[] A, int B, int C, int D) {
        //Optimized apporach:-- TC:O(n) SC: O(n)
        int n = A.length, ans = 0;
        int[] p1 = new int[n];
        int[] p2 = new int[n];
        int[] p3 = new int[n];
        p1[0] = A[0] * B;
        for (int i = 1; i < n; i++) {
            p1[i] = Math.max(p1[i - 1], A[i] * B);
        }
        p2[0] = p1[0] + A[0] * C;
        for (int j = 1; j < n; j++) {
            p2[j] = Math.max(p2[j - 1], (p1[j] + A[j] * C));
        }
        p3[0] = p2[0] + A[0] * D;
        for (int k = 1; k < n; k++) {
            p3[k] = Math.max(p3[k - 1], (p2[k] + A[k] * D));
        }
        ans = p3[0];
        for (int a = 0; a < n; a++) {
            ans = Math.max(ans, p3[a]);
        }
        return ans;

    }
}
