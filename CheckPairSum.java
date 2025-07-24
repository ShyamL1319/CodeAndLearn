import java.util.HashMap;

/**
 * Date: 14/12/2023:08:46
 * User: shyamlal
 * Problem Description
 * Given an Array of integers B, and a target sum A.
 * Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.
 * <p>
 * <p>
 * Problem Constraints
 * 1<= Length of array B <= 103
 * 0<= Bi <=109
 * 0<= A <=109
 * <p>
 * <p>
 * Input Format
 * First argument A is the Target sum, and second argument is the array B
 * <p>
 * <p>
 * Output Format
 * Return an integer value 1 if there exists such pair, else return 0.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 8
 * B = [3, 5, 1, 2, 1, 2]
 * Input 2:
 * <p>
 * A = 21
 * B = [9, 10, 7, 10, 9, 1, 5, 1, 5]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * Example 1:
 * It is possible to obtain sum 8 using 3 and 5.
 * Example 2:
 * There is no such pair exists.
 */
public class CheckPairSum {
    public static void main(String[] args) {
        int A = 7;
        int[] B = {3, 5, 1};
//        System.out.println(checkPairSum(A, B));
        int[] input = {4,0,0,0,4};
//        System.out.println(canJump(input));

        String s1 = "hello";
        String s2 = new String("hello");

        String s3 = "hello";



        if (s1 == s2) {

            System.out.println("s1 and s2 equal (reference)");

        } else {

            System.out.println("s1 and s2 not equal (reference)");

        }

        if (s1.equals(s2)) {

            System.out.println("s1 and s2 equal (value)");

        } else {

            System.out.println("s1 and s2 not equal (value)");

        }



        if (s1 == s3) {

            System.out.println("s1 and s3 equal (reference)");

        } else {

            System.out.println("s1 and s3 not equal (reference)");

        }



        if (s1.equals(s3)) {

            System.out.println("s1 and s3 equal (value)");

        } else {

            System.out.println("s1 and s3 not equal (value)");

        }
    }

    public static int checkPairSum(int A, int[] B) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int len = B.length;
        for (int i = 0; i < len; i++) {
            if (hm.containsKey(B[i])) {
                hm.put(B[i], hm.get(B[i]) + 1);
            } else {
                hm.put(B[i], 1);
            }
        }
        for (int i = 0; i < B.length; i++) {
            int aa = B[i];
            int b = A - aa;
            if (aa == b && hm.get(aa) > 1) {
                return 1;
            }
            if (aa != b && hm.containsKey(b)) {
                return 1;
            }
        }
        return 0;
    }
/**
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * Input: nums = [3,2,1,0,4)
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what, Its maximum jump length is 0, which makes it impossible to reach the last index.
 */

public static boolean canJump(int[] nums) {
    // Variable to track the maximum reachable index
    int maxReach = 0;
    // Iterate through the array
    for (int i = 0; i < nums.length; i++) {
        // If the current index is greater than the maximum reachable index, we cannot proceed
        if (i > maxReach) {
            return false;
        }
        // Update the maximum reachable index
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    // If we successfully iterate through the loop, we can reach the last index
    return true;
}
}
