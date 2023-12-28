/**
 * Date: 28/12/2023:21:19
 * User: shyamlal
 * Problem Description
 * Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
 * Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
 * <p>
 * Note:
 * <p>
 * If there is no such window in A that covers all characters in B, return the empty string.
 * If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size(A), size(B) <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is a string A.
 * The second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string denoting the minimum window.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "ADOBECODEBANC"
 * B = "ABC"
 * Input 2:
 * <p>
 * A = "Aa91b"
 * B = "ab"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "BANC"
 * Output 2:
 * <p>
 * "a91b"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * "BANC" is a substring of A which contains all characters of B.
 * Explanation 2:
 * <p>
 * "a91b" is the substring of A which contains all characters of B.
 */
public class WindowString {
    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        System.out.println(minWindow(A, B));
    }

    public static boolean check(int[] a, int[] b) {
        for (int i = 0; i < 128; i++) {
            if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public static String minWindow(String A, String B) {
        int[] counta = new int[128];
        int[] countb = new int[128];
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < B.length(); i++) {
            int index = B.charAt(i) - ' ';
            countb[index]++;
        }
        int s = 0;
        int e = 0;
        int[] p = new int[2];
        while (e <= A.length() && s <= A.length() && s <= e) {
            if (!check(counta, countb)) {
                if (e == A.length()) {
                    break;
                }
                int index = A.charAt(e) - ' ';
                counta[index]++;
                e++;
            } else {
                if (s == A.length()) {
                    break;
                }
                int index = A.charAt(s) - ' ';
                counta[index]--;
                if (ans > (e - s + 1)) {
                    ans = (e - s + 1);
                    p[0] = s;
                    p[1] = e;
                }
                s++;
            }
        }
        if (ans == Integer.MAX_VALUE) {
            String ss = "";
            return ss;
        }
        return A.substring(p[0], p[1]);
    }
}
