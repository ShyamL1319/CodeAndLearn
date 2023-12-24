import java.util.Arrays;

/**
 * Date: 24/12/2023:23:47
 * User: shyamlal
 * Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 * <p>
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the largest minimum distance possible among the cows.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 * <p>
 * The minimum distance will be 1.
 */
public class AggresiveCows {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(solve(A, B));

    }

    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            min = Math.min(A[i], min);
            max = Math.max(A[i], max);
        }
        max -= min;

        int mid = 0, left = 1, right = max, ans = -1;
        while (left <= right) {
            mid = (right + left) / 2;

            if (isPossibleMaxMin(A, mid, B)) {
                left = mid + 1;
                ans = mid;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPossibleMaxMin(int[] A, int mid, int cows) {
        int count = 1, curr = A[0];

        for (int i = 1; i < A.length; i++) {
            if (A[i] - curr >= mid) {
                count++;
                curr = A[i];
            }
        }
        return count >= cows;

    }
}
