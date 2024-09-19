import java.util.HashSet;

/**
 * Date: 19/12/2023:09:44
 * User: shyamlal
 * Problem Description
 * Given an unsorted integer array A of size N.
 * <p>
 * Find the length of the longest set of consecutive elements from array A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * -106 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 * <p>
 * A = [2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 * <p>
 * The set of consecutive elements will be [1, 2].
 */
public class LongestConsequitiveSeq {
    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};

        System.out.println(longestConsecutive(A));
    }

    public static int longestConsecutive(final int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) set.add(i);
        int maxCount = 0;
        for (int i = 0; i < A.length; i++) {
            int count = 0;
            if (set.contains(A[i] - 1)) continue;
            else {
                int ele = A[i];
                while (set.contains(ele)) {
                    count++;
                    ele++;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
