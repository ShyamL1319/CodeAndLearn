import java.util.HashMap;

/**
 * Date: 27/12/2023:09:12
 * User: shyamlal
 * Problem Description
 * Determine the "GOOD"ness of a given string A, where the "GOOD"ness is defined by the length of the longest substring that contains no repeating characters. The greater the length of this unique-character substring, the higher the "GOOD"ness of the string.
 * <p>
 * Your task is to return an integer representing the "GOOD"ness of string A.
 * <p>
 * Note: The solution should be achieved in O(N) time complexity, where N is the length of the string.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size(A) <= 106
 * <p>
 * String consists of lowerCase,upperCase characters and digits are also present in the string A.
 * <p>
 * <p>
 * <p>
 * Input Format
 * Single Argument representing string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum possible length of substring without repeating characters.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abcabcbb"
 * Input 2:
 * <p>
 * A = "AaaA"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Substring "abc" is the longest substring without repeating characters in string A.
 * Explanation 2:
 * <p>
 * Substring "Aa" or "aA" is the longest substring without repeating characters in string A.
 */
public class LongestSubstringWithoutRepeat {
    public static void main(String[] args) {
        String A = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(A));
    }

    public static int lengthOfLongestSubstring(String A) {
        int N = A.length();
        int ans = 0;
        //int c = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char ch = A.charAt(i);
            if (hm.containsKey(ch)) {
                i = hm.get(ch);
                //c = 0;
                hm.clear();
            } else {
                hm.put(ch, i);
                //c++;
            }
            ans = Math.max(ans, hm.size());
        }
        return ans;
    }
}
