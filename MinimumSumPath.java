/**
 * Date: 24/01/2024:22:12
 * User: shyamlal
 */
public class MinimumSumPath {
//    int n,m;
//    public static void main(String[] args) {
//        MinimumSumPath msp = new MinimumSumPath();
//
//        int input [][] ={
//                {10,20,30,40},
//                {60,50,20,80},
//                {10,10,10,10},
//                {60,50,60,50}
//        };
//        System.out.println(msp.minPathSum(input));
//    }
//
//    int solve(int [][]dp, int [][]grid, int row, int col) {
//        if(row == n-1 && col == m-1) return grid[0][0];
//        if(row >= n || col >= m || col < 0) return Integer.MAX_VALUE;
//        if(dp[row][col] != 0) return dp[row][col];
//
//        int min = Math.min(solve(dp, grid, row+1, col-1), solve(dp, grid, row+1, col));
//        int min2 = Math.min(min, solve(dp, grid, row+1, col+1));
//
//        return dp[row][col] = grid[row][col] + min2;
//
//    }
//    int minPathSum(int[][] grid) {
//        int ans = 0;
//        m = grid.length;
//        n = grid[0].length;
//
//        int dp[][] = new int[n+1][m+1];
//
//        return solve(dp, grid,0, 0);
//
//    }


//    public static int minPathSum(int[][] grid) {
//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return 0;
//        }
//
//        int rows = grid.length;
//        int cols = grid[0].length;
//
//        // Create a 2D array to store the minimum sum values
//        int[][] minSum = new int[rows][cols];
//
//        // Initialize the top-left corner
//        minSum[0][0] = grid[0][0];
//
//        // Initialize the first row
//        for (int i = 1; i < cols; i++) {
//            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
//        }
//
//        // Initialize the first column
//        for (int i = 1; i < rows; i++) {
//            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
//        }
//
//        // Fill in the rest of the matrix with the minimum sum values
//        for (int i = 1; i < rows; i++) {
//            for (int j = 1; j < cols; j++) {
//                minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
//            }
//        }
//
//        // The result is in the bottom-right corner of the matrix
//        return minSum[rows - 1][cols - 1];
//    }

    public static void main(String[] args) {
        MinimumSumPath msp = new MinimumSumPath();

        int[][] input = {
                {10, 20, 30, 40},
                {60, 50, 20, 80},
                {10, 10, 10, 10},
                {60, 50, 60, 50}
        };
        System.out.println(minPathSum(input));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int minSum = Integer.MAX_VALUE;

        // Start the path from each index in the first row and find the minimum sum
        for (int j = 0; j < cols; j++) {
            minSum = Math.min(minSum, minPathSumRecursive(grid, 0, j));
        }

        return minSum;
    }

    private static int minPathSumRecursive(int[][] grid, int i, int j) {
        if (i == grid.length - 1) {
            // If we are at the last row, return the value at the current position
            return grid[i][j];
        }

        int fromLeft = j > 0 ? minPathSumRecursive(grid, i + 1, j - 1) : Integer.MAX_VALUE;
        int fromTop = minPathSumRecursive(grid, i + 1, j);
        int fromRight = j < grid[0].length - 1 ? minPathSumRecursive(grid, i + 1, j + 1) : Integer.MAX_VALUE;

        // Return the minimum sum of the current position and the minimum sum from the next row
        return grid[i][j] + Math.min(Math.min(fromLeft, fromTop), fromRight);
    }
}
