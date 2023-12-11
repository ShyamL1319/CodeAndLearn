/**
 * Date: 11/12/2023:22:42
 * User: shyamlal
 * Problem Description
 * Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.
 * <p>
 * The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.
 * <p>
 * Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= sum of length of all strings <= 1000000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is an array of strings A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the longest common prefix of all strings in A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = ["abcdefgh", "aefghijk", "abcefgh"]
 * Input 2:
 * <p>
 * A = ["abab", "ab", "abcd"];
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "a"
 * Output 2:
 * <p>
 * "ab"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Longest common prefix of all the strings is "a".
 * Explanation 2:
 * <p>
 * Longest common prefix of all the strings is "ab".
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] A = {"abab", "ab", "abcd"};//{"abcdefgh", "aefghijk", "abcefgh"};
        System.out.println(longestCommonPrefixString(A));
    }

    public static String longestCommonPrefixString(String[] A) {
        String res = A[0];

        for (int i = 1; i < A.length; i++) {
            res = common(res, A[i]);
        }

        return res;
    }

    public static String common(String S1, String S2) {

        int n = Math.min(S1.length(), S2.length());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (S1.charAt(i) == S2.charAt(i)) {
                sb.append(S1.charAt(i));
            } else
                break;
        }
        return sb.toString();
    }
}
