/**
 * Problem Description
 * You are given an array A of length N and Q queries given by the 2D array B of size Q*2.
 * Each query consists of two integers B[i][0] and B[i][1].
 * For every query, the task is to calculate the sum of all even indices in the range A[B[i][0]…B[i][1]].
 * <p>
 * Note : Use 0-based indexing
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= Q <= 105
 * 1 <= A[i] <= 100
 * 0 <= B[i][0] <= B[i][1] < N
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers.
 * Second argument B is a 2D array of integers.
 * <p>
 * <p>
 * Output Format
 * Return an array of integers.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = [   [0,2]
 * [1,4]   ]
 * Input 2:
 * A = [2, 1, 8, 3, 9]
 * B = [   [0,3]
 * [2,4]   ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [4, 8]
 * Output 2:
 * [10, 17]
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * The subarray for the first query is [1, 2, 3] whose sum of even indices is 4.
 * The subarray for the second query is [2, 3, 4, 5] whose sum of even indices is 8.
 * For Input 2:
 * The subarray for the first query is [2, 1, 8, 3] whose sum of even indices is 10.
 * The subarray for the second query is [8, 3, 9] whose sum of even indices is 17.
 */

public class SumOfEvenIndices {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[][] B = {
                {0, 2},
                {1, 4}
        };
        Solution<Integer> arrayPrinter = new Solution<>();
        arrayPrinter.printOneDArray(solve(A, B));
    }

    public static Integer[] solve(int[] A, int[][] B) {

        int[] prefix = new int[A.length];
        prefix[0] = A[0];
        for (int i = 1; i < prefix.length; i++) {
            if (i % 2 == 0) {
                prefix[i] = prefix[i - 1] + A[i];
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        Integer[] ans = new Integer[B.length];

        for (int i = 0; i < B.length; i++) {
            int s = B[i][0];
            int e = B[i][1];
            int sum = 0;

            if (s == 0) {
                sum = sum + prefix[e];
            } else {
                sum = sum + prefix[e] - prefix[s - 1];
            }

            ans[i] = sum;
        }

        return ans;


        // BruteForce Method

        // int[] ans = new int[B.length];

        // for(int i = 0; i < B.length; i++){
        //     int s = B[i][0];
        //     int e = B[i][1];
        //     int sum = 0;
        //     for(int j = s; j <= e; j++){
        //         if(j%2 == 0){
        //             sum = sum + A[j];
        //         }
        //     }
        //     ans[i] = sum;
        // }

        // return ans;
    }
}
