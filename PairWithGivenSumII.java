/**
 * Date: 25/12/2023:20:22
 * User: shyamlal
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 * <p>
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 * <p>
 * A = [1, 5, 7, 10]
 * B = 8
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
 * There are 3 pairs.
 * Explanation 2:
 * <p>
 * There is only one pair, such that i = 0, and j = 2 sums up to 8.
 */
public class PairWithGivenSumII {
    public static void main(String[] args) {

    }

    public static int solve(int[] A, int B) {
        long count = 0;
        int s = 0, e = A.length - 1;
        while (s < e) {
            if ((A[s] + A[e]) < B) {
                s++;
            } else if (A[s] + A[e] > B) {
                e--;
            } else {
                if (A[s] == A[e]) {
                    long dupCount = e - s + 1;
                    count = count + (dupCount * (dupCount - 1) / 2);
                    break;
                } else {
                    int leftCount = 0;
                    int rightCount = 0;
                    int x = A[s];
                    int y = A[e];
                    while (A[s] == x) {
                        leftCount++;
                        s++;
                    }
                    while (A[e] == y) {
                        rightCount++;
                        e--;
                    }
                    count = count + ((long) leftCount * rightCount);
                }
            }
        }
        return (int) (count % 1000000007);
    }
}
