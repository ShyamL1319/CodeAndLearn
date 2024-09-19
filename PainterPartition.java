/**
 * Date: 25/12/2023:05:15
 * User: shyamlal
 * Problem Description
 * Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
 * You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
 * <p>
 * Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
 * NOTE:
 * 1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
 * 2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
 * <p>
 * Return the ans % 10000003.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 1000
 * 1 <= B <= 106
 * 1 <= N <= 105
 * 1 <= C[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer A.
 * The second argument given is the integer B.
 * The third argument given is the integer array C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 2
 * B = 5
 * C = [1, 10]
 * Input 2:
 * <p>
 * A = 10
 * B = 1
 * C = [1, 8, 11, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 50
 * Output 2:
 * <p>
 * 11
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Possibility 1:- One painter paints both blocks, time taken = 55 units.
 * Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
 * There are no other distinct ways to paint boards.
 * ans = 50 % 10000003
 * Explanation 2:
 * <p>
 * Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
 * and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
 * ans = 11 % 10000003
 */
public class PainterPartition {
    public static void main(String[] args) {
        int A = 10;
        int B = 1;
        int[] C = {1, 8, 11, 3};

        System.out.println(paint(A, B, C));
    }

    public static int paint(int A, int B, int[] C) {

        long s = C[0];
        long e = C[0];
        int mod = 10000003;
        long ans = 0;
        for (int i = 1; i < C.length; i++) {
            s = Math.max(s, C[i]);
            e = (e + C[i]) % mod;
        }

        while (s <= e) {
            long mid = (s + e) / 2;
            //check if partitioning can be achieved for the particular mid value and number of painters

            if (ispossible(C, A, mid)) {
                ans = (mid * B) % mod;
                e = mid - 1;
            } else {
                s = mid + 1;
            }

        }

        return (int) ans % mod;


    }

    public static boolean ispossible(int[] A, int k, long mid) {
        int sum = 0;
        int p = 1;
        int mod = 10000003;

        for (int el : A) {

            if (el > mid)
                return false;

            sum = (sum % mod + el % mod) % mod;
            //Whenever sum goes beyond the mid, we start the calculating sum again and assign one more painter
            if (sum > mid) {
                p++;
                sum = el;
            }

        }
        //check if the number of painters assigned is less than limit
        return p <= k;
    }
}
