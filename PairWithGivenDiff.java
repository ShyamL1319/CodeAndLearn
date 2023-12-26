import java.util.Arrays;

/**
 * Date: 26/12/2023:06:21
 * User: shyamlal
 * Problem Description
 * Given an one-dimensional integer array A of size N and an integer B.
 * <p>
 * Count all distinct pairs with difference equal to B.
 * <p>
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 104
 * <p>
 * 0 <= A[i], B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an one-dimensional integer array A of size N.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 5, 3, 4, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [8, 12, 16, 4, 0, 20]
 * B = 4
 * Input 3:
 * <p>
 * A = [1, 1, 1, 2, 2]
 * B = 0
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 5
 * Output 3:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * Explanation 2:
 * <p>
 * There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * Explanation 3:
 * <p>
 * There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairWithGivenDiff {
    public static void main(String[] args) {
        int[] A = {1, 5, 3, 4, 2};
        int B = 3;
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int B) {
        Arrays.sort(A);
        int p1 = 0;
        int p2 = 1;
        int n = A.length;
        int count = 0;
        while (p2 < n) {
            int diff = A[p2] - A[p1];
            if (diff == B) {
                count++;
                //Avoid Duplicates int the count
                int x = A[p1];
                int y = A[p2];

                while (p1 < n && A[p1] == x) {
                    p1++;
                }
                while (p2 < n && A[p2] == y) {
                    p2++;
                }
                if (p2 < n && p1 == p2) {
                    p2++;
                }
            } else if (diff > B) {
                //System.out.print(A[p1]);
                p1++;
                if (p1 == p2) {
                    p2++;
                }
            } else {
                //System.out.print(A[p2]);
                p2++;

            }

        }
        return count;
    }
}
