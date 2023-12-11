/**
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * <p>
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * <p>
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 6000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A = "aaaabaaa"
 * Input 2:
 * A = "abba
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * "aaabaaa"
 * Output 2:
 * "abba"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 * Explanation 2:
 * We can see that longest palindromic substring is of length 4 and the string is "abba".
 */

public class LongestPalendromicSubstring {
    public static void main(String[] args) {
        char[] s = {'a', 'b', 'a', 'c', 'a', 'b'};
        int ans = 1;

        for (int i = 0; i < s.length; i++) {
            ans = Math.max(ans, getPalendromicLength(s, i, i));
            if (i > 0) {
                ans = Math.max(ans, getPalendromicLength(s, i - 1, i));
            }
        }
        System.out.println(ans);
        System.out.println(longestPalindrome("abacab"));
    }


    public static int getPalendromicLength(char [] s, int i, int j ) {
        int len = 0;
        int N = s.length;
        if (i == j) {
            len++;
            i--;
            j++;
        }
        while (i >= 0 && j < N && s[i] == s[j]) {
            len += 2;
            i--;
            j++;
        }
        return len;
    }

    public static String longestPalindrome(String A) {
        int start = 0;
        int maxlen = 0;
        int n = A.length();
        for (int i = 0; i < n - maxlen / 2; i++) {
            int j = i;
            int k = i;
            while (k < n - 1 && A.charAt(k) == A.charAt(k + 1))
                k++;
            while (j > 0 && k < n - 1 && A.charAt(j - 1) == A.charAt(k + 1)) {
                j--;
                k++;
            }
            int length = k - j + 1;
            if (length > maxlen) {
                start = j;
                maxlen = length;
            }
        }
        return A.substring(start, start + maxlen);
    }
}
