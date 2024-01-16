import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 16/01/2024:06:27
 * User: shyamlal
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a side with (i, j) and value in that cell is 1.
 * <p>
 * More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
 * <p>
 * (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
 * <p>
 * (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
 * <p>
 * (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
 * <p>
 * (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
 * <p>
 * Return the number of islands.
 * <p>
 * Note:
 * <p>
 * Rows are numbered from top to bottom and columns are numbered from left to right.
 * Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 100
 * 0 <= A[i] <= 1
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer matrix A.
 * <p>
 * <p>
 * Output Format
 * Return the number of islands.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [ [0, 1, 0]
 * [0, 0, 1]
 * [1, 0, 0] ]
 * Input 2:
 * A = [ [1, 1, 0, 0, 0]
 * [1, 1, 0, 0, 0]
 * [0, 0, 0, 0, 0]
 * [0, 0, 0, 1, 1] ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 3
 * Output 2:
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * There are 3 islands in the matrix
 * Explanation 2:
 * There are 2 islands in the matrix
 */
public class NoOfIlansII {
    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        NoOfIlansII noi = new NoOfIlansII();
        System.out.println(noi.solve(A));
    }

    public static void countNoOfIsland(int[][] A, int row, int col) {
        int n = A.length;
        int m = A[0].length;

        Queue<Pairs> q = new LinkedList<>();

        q.add(new Pairs(row, col));
        while (q.size() > 0) {
            Pairs p = q.poll();

            int i = p.i;
            int j = p.j;

            if (i - 1 >= 0 && A[i - 1][j] == 1) {
                q.add(new Pairs(i - 1, j));
                A[i - 1][j] = -1;
            }

            if (j - 1 >= 0 && A[i][j - 1] == 1) {
                q.add(new Pairs(i, j - 1));
                A[i][j - 1] = -1;
            }

            if (i + 1 < n && A[i + 1][j] == 1) {
                q.add(new Pairs(i + 1, j));
                A[i + 1][j] = -1;
            }

            if (j + 1 < m && A[i][j + 1] == 1) {
                q.add(new Pairs(i, j + 1));
                A[i][j + 1] = -1;
            }
        }

    }

    public int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    A[i][j] = -1;
                    countNoOfIsland(A, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static class Pairs {
        int i;
        int j;

        Pairs(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
