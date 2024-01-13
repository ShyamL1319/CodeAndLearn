/**
 * Date: 13/01/2024:23:45
 * User: shyamlal
 * Problem Description
 * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
 * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
 * <p>
 * Return the maximum possible sum.
 * <p>
 * Note: You are allowed to choose more than 2 numbers from the grid.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a 2d matrix, A.
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the maximum possible sum.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [1]
 * [2]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, 2, 3, 4]
 * [2, 3, 4, 5]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 8
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * We will choose 2 (From 2nd row 1st column).
 * Explanation 2:
 * <p>
 * We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).
 */
public class MaxSumWithoutAdjascentEle {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
        };
        System.out.println(adjacent(A));
    }

    public static int adjacent(int[][] A) {
        int ans = 0;
        int n = 2;
        int m = A[0].length;
        int[] max = new int[m];
        //convert 2 * grid into 1 * grid based on observation
        for (int i = 0; i < m; i++) {
            A[0][i] = Math.max(A[0][i], A[1][i]);
        }

        for (int i = 0; i < m; i++) {
            if (i == 0) {
                max[0] = A[0][0];
            } else if (i == 1) {
                max[i] = Math.max(max[i - 1], A[0][i]);
            } else {
                max[i] = Math.max(max[i - 1], max[i - 2] + A[0][i]);
            }
        }

        return max[m - 1];
    }
}
