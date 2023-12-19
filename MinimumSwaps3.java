/**
 * Date: 19/12/2023:09:05
 * User: shyamlal
 * Problem Description
 * <p>
 * Given an array of integers A and an integer B, find and return the minimum number of swaps required to bring all the numbers less than or equal to B together.
 * <p>
 * Note: It is possible to swap any two elements, not necessarily consecutive.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * -109 <= A[i], B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the minimum number of swaps.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = [1, 12, 10, 3, 14, 10, 5]
 * B = 8
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 20
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * A = [1, 12, 10, 3, 14, 10, 5]
 * After swapping  12 and 3, A => [1, 3, 10, 12, 14, 10, 5].
 * After swapping  the first occurence of 10 and 5, A => [1, 3, 5, 12, 14, 10, 10].
 * Now, all elements less than or equal to 8 are together.
 * Explanation 2:
 * <p>
 * A = [5, 17, 100, 11]
 * After swapping 100 and 11, A => [5, 17, 11, 100].
 * Now, all elements less than or equal to 20 are together.
 */
public class MinimumSwaps3 {
    public static void main(String[] args) {
        int[] A = {1, 12, 10, 3, 14, 10, 5};
        int B = 8;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {

        //Step 1: Counting the number of elements which are less than or equal to B
        int minCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                minCount++;
            }
        }

        //Step 2: After calculating the #elements less than or equal to k
        //this count becomes the length of our sliding window.
        //counting the #elements (in var maxCount) greater B in this window
        int maxCount = 0;
        for (int i = 0; i < minCount; i++) {
            if (A[i] > B) {
                maxCount++;
            }
        }

        //Step 3: minSwap is the answer variable.
        //Initializing minSwap with maxCount for the current window
        int minSwap = maxCount;

        for (int i = minCount; i < A.length; i++) {

            //Checking if the current window is greater than B
            //If true then increment maxCount by 1

            if (A[i] > B) {
                maxCount++;
            }

            //Checking if the previous window was greater than B
            //If true then decrement maxCount by 1
            //leaving bigger element behind

            if (A[i - minCount] > B) {
                maxCount--;
            }

            //Checking if the current window (maxCount) or previous window is lesser
            //If maxCount (current window count) < minSwap (previous window count)
            //Then update minimum value
            minSwap = Math.min(minSwap, maxCount);

        }

        return minSwap;
    }
}
