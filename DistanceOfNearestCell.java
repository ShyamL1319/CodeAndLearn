import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 16/01/2024:06:30
 * User: shyamlal
 * Problem Description
 * Given a matrix of integers A of size N x M consisting of 0 or 1.
 * <p>
 * For each cell of the matrix find the distance of nearest 1 in the matrix.
 * <p>
 * Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
 * <p>
 * Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.
 * <p>
 * NOTE: There is atleast one 1 is present in the matrix.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * <p>
 * 0 <= A[i][j] <= 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the matrix B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [0, 0, 0, 1]
 * [0, 0, 1, 1]
 * [0, 1, 1, 0]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, 0, 0]
 * [0, 0, 0]
 * [0, 0, 0]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * [3, 2, 1, 0]
 * [2, 1, 0, 0]
 * [1, 0, 0, 1]
 * ]
 * Output 2:
 * <p>
 * [
 * [0, 1, 2]
 * [1, 2, 3]
 * [2, 3, 4]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A[0][0], A[0][1], A[0][2] will be nearest to A[0][3].
 * A[1][0], A[1][1] will be nearest to A[1][2].
 * A[2][0] will be nearest to A[2][1] and A[2][3] will be nearest to A[2][2].
 * Explanation 2:
 * <p>
 * There is only a single 1. Fill the distance from that 1.
 */
public class DistanceOfNearestCell {
    public static void main(String[] args) {

    }

    public int[][] solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] ans = new int[n][m];

        if (n == 1 && m == 1) {
            return ans;
        }


        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) { //  Iterate on A and add all the pairs into queue which have value as 1
                    q.add(new Pair(i, j));
                    A[i][j] = -1; // update that pair as -1 after adding into queue
                }
            }
        }

        /*
            Steps ->
            1. Iterate on queue and poll every pair one by one
            2. While iterating check if TRBL of current pair is 0 or not
            3. If 0 then add that pair into queue
            4. and change the value of TRBL as -1 in input array
            5. In ans array
        */
        while (q.size() > 0) {
            Pair p = q.poll();
            int i = p.i;
            int j = p.j;
            int val = ans[i][j];

            if (i - 1 >= 0 && A[i - 1][j] == 0) {
                q.add(new Pair(i - 1, j));
                A[i - 1][j] = -1;
                ans[i - 1][j] = val + 1;
            }

            if (j - 1 >= 0 && A[i][j - 1] == 0) {
                q.add(new Pair(i, j - 1));
                A[i][j - 1] = -1;
                ans[i][j - 1] = val + 1;
            }

            if (i + 1 < n && A[i + 1][j] == 0) {
                q.add(new Pair(i + 1, j));
                A[i + 1][j] = -1;
                ans[i + 1][j] = val + 1;
            }

            if (j + 1 < m && A[i][j + 1] == 0) {
                q.add(new Pair(i, j + 1));
                A[i][j + 1] = -1;
                ans[i][j + 1] = val + 1;
            }
        }

        return ans;
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
