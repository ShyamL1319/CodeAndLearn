import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 16/01/2024:05:49
 * User: shyamlal
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * <p>
 * Each cell can have three values:
 * <p>
 * The value 0 representing an empty cell.
 * <p>
 * The value 1 representing a fresh orange.
 * <p>
 * The value 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten. Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 * <p>
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * <p>
 * 0 <= A[i][j] <= 2
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * <p>
 * If this is impossible, return -1 instead.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [   [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1]   ]
 * Input 2:
 * <p>
 * <p>
 * A = [   [2, 1, 1]
 * [0, 1, 1]
 * [1, 0, 1]   ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Minute 0: [ [2, 1, 1]
 * [1, 1, 0]
 * [0, 1, 1] ]
 * Minute 1: [ [2, 2, 1]
 * [2, 1, 0]
 * [0, 1, 1] ]
 * Minute 2: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 1, 1] ]
 * Minute 3: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 1] ]
 * Minute 4: [ [2, 2, 2]
 * [2, 2, 0]
 * [0, 2, 2] ]
 * At Minute 4, all the oranges are rotten.
 * Explanation 2:
 * <p>
 * The fresh orange at 2nd row and 0th column cannot be rotten, So return -1.
 */
public class RottenOranges {
    public static void main(String[] args) {
        int[][] A = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(solve(A));

    }

    public static int solve(int[][] A) {

        int n = A.length;
        int m = A[0].length;

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) { // Iterate on matrix and add all the pairs into queue which have 2
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 2) {
                    q.add(new Pair(i, j));
                    A[i][j] = -1; // and update element to -1
                }
            }
        }

        while (q.size() > 0) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int val = A[i][j];

            if (i - 1 >= 0 && A[i - 1][j] == 1) { // search for i-1, j
                q.add(new Pair(i - 1, j));
                A[i - 1][j] = val - 1;
            }
            if (j - 1 >= 0 && A[i][j - 1] == 1) { // search for i, j-1
                q.add(new Pair(i, j - 1));
                A[i][j - 1] = val - 1;
            }
            if (i + 1 < n && A[i + 1][j] == 1) { // search for i+1, j
                q.add(new Pair(i + 1, j));
                A[i + 1][j] = val - 1;
            }
            if (j + 1 < m && A[i][j + 1] == 1) { // search for i, j+1
                q.add(new Pair(i, j + 1));
                A[i][j + 1] = val - 1;
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) { // iterate on updated matrix and check if there any orag=nges left then return -1
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) { // if there any oranges left then return -1
                    return -1;
                }
                min = Math.min(min, A[i][j]); // otherwise update min with min element present in matrix
            }
        }

        return min * -1 - 1; // convert negative to positive and then subtract -1
    }

    static class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
