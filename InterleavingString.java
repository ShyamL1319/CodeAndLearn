/**
 * Date: 15/01/2024:17:45
 * User: shyamlal
 * Problem Description
 * Given A, B, C find whether C is formed by the interleaving of A and B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A), length(B) <= 100
 * <p>
 * 1 <= length(C) <= 200
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * The third argument of input contains a string, C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if string C is formed by interleaving of A and B else 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "aabcc"
 * B = "dbbca"
 * C = "aadbbcbcac"
 * Input 2:
 * <p>
 * A = "aabcc"
 * B = "dbbca"
 * C = "aadbbbaccc"
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
 * "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
 * Explanation 2:
 * <p>
 * It is not possible to get C by interleaving A and B.
 */
public class InterleavingString {
    public static void main(String[] args) {
        InterleavingString ils = new InterleavingString();
        System.out.println(ils.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

    public int isInterleave(String A, String B, String C) {
        if (C.length() != (A.length() + B.length())) {
            return 0;
        }
        if (check(A, 0, B, 0, C, 0)) {
            return 1;
        }
        return 0;
    }

    public boolean check(String A, int i, String B, int j, String C, int k) {
        if (i == A.length() && j == B.length()) {
            return k == C.length();
        }
        if (k >= C.length()) {
            return false;
        }
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;

        if (i < A.length() && A.charAt(i) == C.charAt(k)) {

            flag1 = check(A, i + 1, B, j, C, k + 1);
        }
        if (j < B.length() && B.charAt(j) == C.charAt(k)) {

            flag2 = check(A, i, B, j + 1, C, k + 1);
        }

        flag = flag1 | flag2;
        return flag;

    }
}
