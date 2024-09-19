/**
 * Problem Description
 * A wire connects N light bulbs.
 * <p>
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 * <p>
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * <p>
 * You can press the same switch multiple times.
 * <p>
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= N <= 5×105
 * 0 <= A[i] <= 1
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument contains an integer array A, of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer representing the minimum number of switches required.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [0, 1, 0, 1]
 * Input 2:
 * <p>
 * A = [1, 1, 1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * press switch 0 : [1 0 1 0]
 * press switch 1 : [1 1 0 1]
 * press switch 2 : [1 1 1 0]
 * press switch 3 : [1 1 1 1]
 * Explanation 2:
 * <p>
 * There is no need to turn any switches as all the bulbs are already on.
 */

public class BulbSwitches {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1};
        System.out.println(minBulbSwitchs(arr));
    }

    public static int minBulbSwitchs(int[] A) {
        int n = A.length;
        int count = 0;
        int i = 0;
        while (i < n) {

            if (count % 2 == 0 && A[i] == 0)
                count++;

            if (count % 2 != 0 && A[i] == 1)
                count++;

            i++;
        }

        return count;
    }
}
