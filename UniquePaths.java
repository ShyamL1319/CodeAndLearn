/**
 * Date: 14/01/2024:00:04
 * User: shyamlal
 * Problem Description
 * Given a grid of size n * m, lets assume you are starting at (1,1) and your goal is to reach (n, m).
 * At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
 * <p>
 * Now consider if some obstacles are added to the grids.
 * Return the total number unique paths from (1, 1) to (n, m).
 * <p>
 * Note:
 * 1. An obstacle is marked as 1 and empty space is marked 0 respectively in the grid.
 * 2. Given Source Point and Destination points are 1-based index.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= n, m <= 100
 * A[i][j] = 0 or 1
 * <p>
 * <p>
 * Input Format
 * Firts and only argument A is a 2D array of size n * m.
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the number of unique paths from (1, 1) to (n, m).
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [0, 0, 0]
 * [0, 1, 0]
 * [0, 0, 0]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [0, 0, 0]
 * [1, 1, 1]
 * [0, 0, 0]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Possible paths to reach (n, m): {(1, 1), (1, 2), (1, 3), (2, 3), (3, 3)} and {(1 ,1), (2, 1), (3, 1), (3, 2), (3, 3)}
 * So, the total number of unique paths is 2.
 * Explanation 2:
 * <p>
 * It is not possible to reach (n, m) from (1, 1). So, ans is 0.
 */
public class UniquePaths {
    public static int[][] dp;

    public static void main(String[] args) {
        int[][] A = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(A));
    }

    public static int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        dp = new int[n][m];
        // filling dp array '-1'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(A, n - 1, m - 1);
    }

    public static int helper(int[][] arr, int i, int j) {
        // Base case: If we go out of bounds
        if (i < 0 || j < 0) {
            return 0;
        }
        // Base case : when arr[][]==1
        if (arr[i][j] == 1) {
            return 0;
        }
        // Base case: return 1
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int a = helper(arr, i - 1, j);
        int b = helper(arr, i, j - 1);

        return dp[i][j] = a + b;
    }
}
