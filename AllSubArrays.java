import java.util.Arrays;

/**
 * Problem Description
 * You are given an array A of N integers.
 * Return a 2D array consisting of all the subarrays of the array
 * <p>
 * Note : The order of the subarrays in the resulting 2D array does not matter.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100
 * 1 <= A[i] <= 105
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers.
 * <p>
 * <p>
 * Output Format
 * Return a 2D array of integers in any order.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 2, 3]
 * Input 2:
 * A = [5, 2, 1, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
 * Output 2:
 * [[1 ], [1 4 ], [2 ], [2 1 ], [2 1 4 ], [4 ], [5 ], [5 2 ], [5 2 1 ], [5 2 1 4 ] ]
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * All the subarrays of the array are returned. There are a total of 6 subarrays.
 * For Input 2:
 * All the subarrays of the array are returned. There are a total of 10 subarrays.
 */
public class AllSubArrays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[][] res = solve(arr);
        for (int[] ele : res) {
            System.out.println(Arrays.toString(ele));
        }
    }

    public static int[][] solve(int[] A) {
        int n = A.length;
        int N = n * (n + 1) / 2;
        int[][] result = new int[N][];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] resArr = new int[j - i + 1];
                if (j + 1 - i >= 0) System.arraycopy(A, i, resArr, i - i, j + 1 - i);
                if (cnt < N) {
                    result[cnt] = resArr;
                    cnt += 1;
                }
            }
        }
        return result;
    }
}
