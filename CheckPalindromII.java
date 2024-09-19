import java.util.HashMap;

/**
 * Date: 30/12/2023:22:46
 * User: shyamlal
 * Problem Description
 * Given a string A consisting of lowercase characters.
 * <p>
 * Check if characters of the given string can be rearranged to form a palindrome.
 * <p>
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * A consists only of lower-case characters.
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if it is possible to rearrange the characters of the string A such that it becomes a palindrome else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abcde"
 * Input 2:
 * <p>
 * A = "abbaee"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * No possible rearrangement to make the string palindrome.
 * Explanation 2:
 * <p>
 * Given string "abbaee" can be rearranged to "aebbea" to form a palindrome.
 */
public class CheckPalindromII {
    public static void main(String[] args) {
        System.out.println(solve("aebbea"));

    }

    public static int solve(String A) {
        int n = A.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char ch = A.charAt(i);
            if (map.containsKey(ch)) {
                //remove the Character
                map.remove(ch);
            } else {
                //adding in map
                map.put(ch, 1);
            }
        }
        if (map.size() == 0 || map.size() == 1) {
            return 1;
        }
        return 0;
    }
}
