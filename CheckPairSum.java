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
        System.out.println(checkPairSum(A, B));
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
}
