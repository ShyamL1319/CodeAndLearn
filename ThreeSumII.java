import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date: 26/12/2023:06:42
 * User: shyamlalProblem Description
 * Jerry is excited about an array that Tom gave him. The array A consists of N integers.
 * <p>
 * Tom challenges Jerry to find all such unique triplets a, b, c in A such that a + b = - c.
 * <p>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-decreasing order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= N <= 7000
 * <p>
 * -108 <= A[i] <= 108
 * <p>
 * <p>
 * <p>
 * Input Format
 * Single argument representing a 1-D array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Output a 2-D vector where each row represent a unique triplet.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = [-5, 2, 1, 3]
 * Input 2:
 * A = [-1, 0, 1, 2, -1, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * [[-5, 2, 3]]
 * Output 2:
 * [[-1,0,1],
 * [-1,-1,2] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * Out of all the possible triplets, the triplet (-5, 2, 3) only satisfies the condition, which is in the form [ (-5) + (2) = - (3) ]
 * Explanation 2:
 * Out of all the possible triplets only the above two triplets satisfies the condition and unique.
 */
public class ThreeSumII {
    public static void main(String[] args) {
        int[] A = {-5, 2, 1, 3};
        int[][] res = threeSum(A);

        for (int[] ele : res) {
            for (int e : ele) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int[][] threeSum(int[] A) {
        Set<List<Integer>> set = new HashSet<>();
        int n = A.length;
        Arrays.sort(A);
        for (int i = 0; i < n - 2; i++) {
            int s = i + 1, e = n - 1;
            while (s < e) {
                int sum = A[i] + A[s] + A[e];
                if (sum == 0) {
                    List<Integer> triplet = Arrays.asList(A[i], A[s], A[e]);
                    set.add(triplet);
                    s++;
                    e--;
                } else if (sum < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        int[][] res = new int[set.size()][3];
        int i = 0;
        for (List<Integer> triplets : set) {
            res[i][0] = triplets.get(0);
            res[i][1] = triplets.get(1);
            res[i][2] = triplets.get(2);
            i++;
        }
        return res;
    }
}
