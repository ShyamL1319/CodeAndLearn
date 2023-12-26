/**
 * Date: 26/12/2023:06:54
 * User: shyamlal
 * Problem Description
 * Given an array with N objects colored red, white, or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * <p>
 * We will represent the colors as,
 * <p>
 * red -> 0
 * white -> 1
 * blue -> 2
 * <p>
 * Note: Using the library sort function is not allowed.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000
 * 0 <= A[i] <= 2
 * <p>
 * <p>
 * Input Format
 * First and only argument of input contains an integer array A.
 * <p>
 * <p>
 * Output Format
 * Return an integer array in asked order
 * <p>
 * <p>
 * Example Input
 * Input 1 :
 * A = [0, 1, 2, 0, 1, 2]
 * Input 2:
 * <p>
 * A = [0]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [0, 0, 1, 1, 2, 2]
 * Output 2:
 * <p>
 * [0]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * [0, 0, 1, 1, 2, 2] is the required order.
 * Explanation 2:
 * [0] is the required order
 */
public class SortByColors {
    public static void main(String[] args) {
        int[] A = {0, 1, 2, 0, 1, 2};
        int[] res = sortColors(A);
        for (int d : res) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static int[] sortColors(int[] A) {
        int i = 0;
        int j = 0;
        int k = A.length - 1;
        while (i <= k) {
            if (A[i] == 0) {
                swap(A, i, j);
                i++;
                j++;
            } else if (A[i] == 1) {
                i++;
            } else if (A[i] == 2) {
                swap(A, i, k);
                k--;
            }
        }
        return A;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
