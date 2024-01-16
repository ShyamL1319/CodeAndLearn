/**
 * Date: 16/01/2024:06:11
 * User: shyamlal
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 * <p>
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 * <p>
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
 * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
 * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
 * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
 * (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
 * (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
 * (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
 * (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
 * Return the number of islands.
 * <p>
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 100
 * <p>
 * 0 <= A[i] <= 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the number of islands.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [0, 1, 0]
 * [0, 0, 1]
 * [1, 0, 0]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, 1, 0, 0, 0]
 * [0, 1, 0, 0, 0]
 * [1, 0, 0, 1, 1]
 * [0, 0, 0, 0, 0]
 * [1, 0, 1, 0, 1]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The 1's at position A[0][1] and A[1][2] forms one island.
 * Other is formed by A[2][0].
 * Explanation 2:
 * <p>
 * There 5 island in total.
 */
public class NoOfIlands {
    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        NoOfIlands noi = new NoOfIlands();
        System.out.println(noi.solve(A));
    }

    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int icount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    icount++;
                    callDFS(A, i, j);
                }
            }
        }

        return icount;
    }

    public void callDFS(int[][] A, int i, int j) {
        if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] == 0) {
            return;
        }

        A[i][j] = 0;

        int[] row = new int[]{-1, -1, -1, 0, 0, +1, +1, +1};
        int[] col = new int[]{-1, 0, +1, -1, +1, -1, 0, +1};
        for (int k = 0; k < 8; k++) {
            callDFS(A, i + row[k], j + col[k]);
        }

        // callDFS(A, i - 1, j - 1); // topleft
        // callDFS(A, i - 1, j);     // top
        // callDFS(A, i - 1, j + 1); // topright
        // callDFS(A, i, j - 1);     // left
        // callDFS(A, i, j + 1);     // right
        // callDFS(A, i + 1, j - 1); // bottomleft
        // callDFS(A, i + 1, j);     // bottom
        // callDFS(A, i + 1, j + 1); // bottomright
    }
}
