import java.util.Arrays;

/**
 * Date: 18/12/2023:09:43
 * User: shyamlal
 * Problem Description
 * Given an array A of N integers where the i-th element represent the number of chocolates in the i-th packet.
 * <p>
 * There are B number of students, the task is to distribute chocolate packets following below conditions:
 * <p>
 * 1. Each student gets one packets.
 * 2. The difference between the number of chocolates given to any two students is minimum.
 * Return the minimum difference (that can be achieved) between the student who gets minimum number of chocolates and the student who gets maximum number of chocolates.
 * <p>
 * Note: If you can't give each student 1 packet, return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= N <= 10^5
 * 1 <= A[i] <= 10^7
 * 0 <= B <= 10^5
 * <p>
 * <p>
 * Input Format
 * The first argument contains an integer array A.
 * <p>
 * The second argument contains an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
 * <p>
 * <p>
 * Example Input
 * Input:
 * <p>
 * A : [3, 4, 1, 9, 56, 7, 9, 12]
 * B : 5
 * <p>
 * <p>
 * Example Output
 * Output:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation:
 * <p>
 * <p>
 * We can choose the packets with chocolates = [3, 4, 9, 7, 9]
 * The difference between maximum and minimum is 9-3 = 6
 */
public class ChocolateDistribution {
    public static void main(String[] args) {
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        int B = 5;
        System.out.println(distribute(A, B));
    }

    public static int distribute(int[] A, int B) {
        int n = A.length;
        if (B == 0 || B > n) {
            return 0;
        }
        Arrays.sort(A);
        int ans = Integer.MAX_VALUE;
        int s = 0;
        int e = B - 1;
        while (e < n) {
            int maxC = A[e];
            int minC = A[s];
            ans = Math.min(ans, maxC - minC);
            s++;
            e++;
        }
        return ans;
    }
}
