/**
 * Date: 20/12/2023:08:04
 * User: shyamlal
 * Problem Description
 * Given a sorted array of integers A of size N and an integer B,
 * where array A is rotated at some pivot unknown beforehand.
 * <p>
 * For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
 * <p>
 * Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
 * <p>
 * You can assume that no duplicates exist in the array.
 * <p>
 * NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000000
 * 1 <= A[i] <= 109
 * All elements in A are Distinct.
 * <p>
 * <p>
 * Input Format
 * The First argument given is the integer array A.
 * The Second argument given is the integer B.
 * <p>
 * <p>
 * Output Format
 * Return index of B in array A, otherwise return -1
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 5, 6, 7, 0, 1, 2, 3]
 * B = 4
 * Input 2:
 * <p>
 * A : [ 9, 10, 3, 5, 6, 8 ]
 * B : 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Target 4 is found at index 0 in A.
 * Explanation 2:
 * <p>
 * Target 5 is found at index 3 in A.
 */
public class RotatedSortedArraySearch {
    public static void main(String[] args) {
        int[] A = {4, 5, 6, 7, 0, 1, 2, 3};
        int B = 8;
        System.out.println(search(A, B));
    }

    public static int search(final int[] A, int B) {

        int left = 0, right = A.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (A[mid] == B) {
                return mid;
            } else if (A[left] < A[mid]) {
                if (B >= A[left] && B < A[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (B <= A[right] && B > A[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
