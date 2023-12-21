/**
 * Date: 21/12/2023:10:30
 * User: shyamlal
 * Problem Description
 * Given an integer A. Compute and return the square root of A.
 * If A is not a perfect square, return floor(sqrt(A)).
 * <p>
 * NOTE:
 * The value of A*A can cross the range of Integer.
 * Do not use the sqrt function from the standard library.
 * Users are expected to solve this in O(log(A)) time.
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A <= 109
 * <p>
 * <p>
 * Input Format
 * The first and only argument given is the integer A.
 * <p>
 * <p>
 * Output Format
 * Return floor(sqrt(A))
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 11
 * Input 2:
 * <p>
 * 9
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 * Explanatino 2:
 * When A = 9 which is a perfect square of 3, so we return 3.
 */
public class SquareRootOfInteger {
    public static void main(String[] args) {
        int A = 11;
        System.out.println(sqrt(A));
    }

    public static int sqrt(int A) {
        // Initialize the low, high, and answer variables
        int lo = 1;
        int hi = A;
        int ans = 1;

        // Edge case: if A is 0, return 0 since the square root of 0 is 0
        if (A == 0) {
            return 0;
        }

        // Binary search to find the square root
        while (lo <= hi) {
            // Calculate the mid-point
            int mid = (lo + hi) / 2;

            // Check if mid is the square root of A
            if (mid == A / mid) {
                ans = mid;
                break;
            }
            // If mid is less than A/mid, update the answer and search in the right half
            else if (mid < A / mid) {
                ans = mid;
                lo = mid + 1;
            }
            // If mid is greater than A/mid, search in the left half
            else {
                hi = mid - 1;
            }
        }
        // Return the square root
        return ans;
    }
}
