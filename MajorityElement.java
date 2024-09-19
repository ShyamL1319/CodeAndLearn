/**
 * Problem Description
 * Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
 * If there is no majority element then return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 5*105
 * 1 <= num[i] <= 109
 * <p>
 * <p>
 * Input Format
 * Only argument is an integer array.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * [2, 1, 2]
 * Input 2:
 * [1, 1, 1]
 * <p>
 * <p>
 * Example Output
 * Input 1:
 * 2
 * Input 2:
 * 1
 * <p>
 * <p>
 * Example Explanation
 * For Input 1:
 * 2 occurs 2 times which is greater than 3/2.
 * For Input 2:
 * 1 is the only element in the array, so it is majority
 */

public class MajorityElement {
    public static void main(String[] args) {
        int[] A = {1, 2, 6, 3, 3, 4, 3};
        //System.out.println(majorityElementNby2(A));
        System.out.println(majorityElementNby3(A));
    }

    public static int majorityElementNby2(final int[] A) {
        int freq = 1;
        int ans = A[0];
        int N = A.length;
        for (int i = 1; i < N; i++) {
            if (ans == A[i]) {
                freq++;
            } else {
                freq--;
            }
            if (freq == 0) {
                ans = A[i];
                freq = 1;
            }
        }
        freq = 0;
        for (int j = 0; j < N; j++) {
            if (A[j] == ans) freq++;
        }
        if (freq > (N / 2))
            return ans;
        else
            return -1;
    }

    public static int majorityElementNby3(final int[] A) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MIN_VALUE;
        int count1 = 0, count2 = 0;
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (first == A[i]) {
                count1++;
            } else if (second == A[i]) {
                count2++;
            } else if (count1 == 0) {
                count1 = 1;
                first = A[i];
            } else if (count2 == 0) {
                count2 = 1;
                second = A[i];
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == first) count1++;
            if (A[i] == second) count2++;
        }
        if (count1 > N / 3) return first;
        if (count2 > N / 3) return second;
        return -1;
    }
}
