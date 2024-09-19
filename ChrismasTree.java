/**
 * Problem Description
 * You are given an array A consisting of heights of Christmas trees and an array B of the same size consisting of the cost of each of the trees (Bi is the cost of tree Ai, where 1 ≤ i ≤ size(A)), and you are supposed to choose 3 trees (let's say, indices p, q, and r), such that Ap < Aq < Ar, where p < q < r.
 * The cost of these trees is Bp + Bq + Br.
 * <p>
 * You are to choose 3 trees such that their total cost is minimum. Return that cost.
 * <p>
 * If it is not possible to choose 3 such trees return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A[i], B[i] <= 109
 * 3 <= size(A) = size(B) <= 3000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * Second argument is an integer array B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum cost of choosing 3 trees whose heights are strictly in increasing order,
 * if not possible, -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 3, 5]
 * B = [1, 2, 3]
 * Input 2:
 * <p>
 * A = [1, 6, 4, 2, 6, 9]
 * B = [2, 5, 7, 3, 2, 7]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 6
 * Output 2:
 * <p>
 * 7
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * We can choose the trees with indices 1, 2 and 3, and the cost is 1 + 2 + 3 = 6.
 * Explanation 2:
 * <p>
 * We can choose the trees with indices 1, 4 and 5, and the cost is 2 + 3 + 2 = 7.
 * This is the minimum cost that we can get.
 */

public class ChrismasTree {
    public static void main(String[] args) {

        int[] A = {1, 6, 4, 2, 6, 9};
        int[] B = {2, 5, 7, 3, 2, 7};
        System.out.println(chrismasTree(A, B));
    }

    public static int chrismasTree(int[] A, int[] B) {
        final int inf = (int) (1e9 + 10);
        int minCost = inf;
        for (int i = 0; i < A.length; i++) {
            int leftMin = inf;
            int rightMin = inf;

            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    leftMin = Math.min(B[j], leftMin);
                }
            }

            for (int k = i + 1; k < A.length; k++) {
                if (A[i] < A[k]) {
                    rightMin = Math.min(B[k], rightMin);
                }
            }
            minCost = Math.min(minCost, leftMin + rightMin + B[i]);

        }

        if (minCost == inf) return -1;
        else return minCost;
    }
}
