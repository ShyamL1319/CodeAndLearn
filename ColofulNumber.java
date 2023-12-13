import java.util.ArrayList;
import java.util.HashSet;

/**
 * Date: 13/12/2023:09:31
 * User: shyamlal
 * Problem Description
 * Given a number A, find if it is COLORFUL number or not.
 * <p>
 * If number A is a COLORFUL number return 1 else, return 0.
 * <p>
 * What is a COLORFUL Number:
 * <p>
 * A number can be broken into different consecutive sequence of digits.
 * The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245.
 * This number is a COLORFUL number, since the product of every consecutive sequence of digits is different
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 2 * 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if integer A is COLORFUL else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 23
 * Input 2:
 * <p>
 * A = 236
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
 * Explanation 1:
 * <p>
 * Possible Sub-sequences: [2, 3, 23] where
 * 2 -> 2
 * 3 -> 3
 * 23 -> 6  (product of digits)
 * This number is a COLORFUL number since product of every digit of a sub-sequence are different.
 * Explanation 2:
 * <p>
 * Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 * 2 -> 2
 * 3 -> 3
 * 6 -> 6
 * 23 -> 6  (product of digits)
 * 36 -> 18  (product of digits)
 * 236 -> 36  (product of digits)
 * This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.
 */
public class ColofulNumber {
    public static void main(String[] args) {
        System.out.println(colorful(2564));
    }

    public static int colorful(int A) {
        ArrayList<Integer> arr = new ArrayList<>();

        while (A > 0) {
            arr.add(A % 10);
            A /= 10;
        }
        final int n = arr.size();
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= arr.get(j);
                if (hs.contains(prod)) {
                    return 0;
                } else {
                    hs.add(prod);
                }
            }
        }
        return 1;
    }
}
