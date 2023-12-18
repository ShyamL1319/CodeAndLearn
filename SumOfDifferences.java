import java.util.Arrays;

/**
 * Date: 18/12/2023:08:04
 * User: shyamlal
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then,
 * for each subsequence, find the difference between the largest and smallest number in that subsequence.
 * Then add up all the differences to get the number.
 * <p>
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 * <p>
 * NOTE: Subsequence can be non-contiguous.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 10000
 * <p>
 * 1<= A[i] <=1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the output.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2]
 * Input 2:
 * <p>
 * A = [3, 5, 10]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 21
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * All possible non-empty subsets are:
 * [1]     largest-smallest = 1 - 1 = 0
 * [2]     largest-smallest = 2 - 2 = 0
 * [1, 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 * <p>
 * All possible non-empty subsets are:
 * [3]         largest-smallest = 3 - 3 = 0
 * [5]         largest-smallest = 5 - 5 = 0
 * [10]        largest-smallest = 10 - 10 = 0
 * [3, 5]      largest-smallest = 5 - 3 = 2
 * [3, 10]     largest-smallest = 10 - 3 = 7
 * [5, 10]     largest-smallest = 10 - 5 = 5
 * [3, 5, 10]  largest-smallest = 10 - 3 = 7
 * Sum of the differences = 0 + 0 + 0 + 2 + 7 + 5 + 7 = 21
 * So, the resultant number is 21
 */
public class SumOfDifferences {
    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int n = A.length;
        double max = 0, min = 0;
        double diff;
        double mod = 1000000007;
        Arrays.sort(A);
        // max and min of sub sequence
        for (int i = 0; i < n; i++) {
            double maxcontribution = (A[i] * Math.pow(2, i)) % mod;    //(1 << i)) % mod; //(int) Math.pow(2,i);
            max = (max + maxcontribution) % mod;
            double mincontribution = (A[i] * Math.pow(2, (n - 1 - i))) % mod;//(1 << (n - 1 - i))) % mod;  //(int) Math.pow(2,j);
            min = (min + mincontribution) % mod;
        }
        diff = (max - min + mod) % mod;
        return (int) diff;
    }
}
