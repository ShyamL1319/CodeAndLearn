import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Date: 08/01/2024:07:34
 * User: shyamlal
 * Problem Description
 * Imagine you're a teacher. You ask students to call out a letter one by one. After each letter, you jot down the very first letter that's only been called out once. If all letters have been repeated, you write "#".
 * <p>
 * Here's a scenario:
 * <p>
 * A student says "a". It's the first letter. You write "a".
 * Next, a student says "b", "a" is still unique, so you add "a". Now it's "aa".
 * A student says "a" again. Now, "b" is the unique one. You add "b", making it "aab".
 * A student says "b". All letters so far are repeated. You add "#". It becomes "aab#".
 * A student says "c". "c" is unique. You add "c". The final is "aab#c".
 * Your task? Given the sequence the students call out A, determine the string on the board.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string after processing the stream of lowercase alphabets A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abadbc"
 * Input 2:
 * <p>
 * A = "abcabc"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "aabbdd"
 * Output 2:
 * <p>
 * "aaabc#"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "aba"    -   first non repeating character 'b'
 * "abad"   -   first non repeating character 'b'
 * "abadb"  -   first non repeating character 'd'
 * "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "abc"    -   first non repeating character 'a'
 * "abca"   -   first non repeating character 'b'
 * "abcab"  -   first non repeating character 'c'
 * "abcabc" -   no non repeating character so '#'
 */
public class UniqueLetter {
    public static void main(String[] args) {
        System.out.println(solve("abadbc"));
    }

    public static String solve(String A) {
        /*Idea:
        Maintain a Queue to track the set of strings.
        Maintain a map to identify the char that is appearing in main straing.
        At any point if char freq is more than 2 we should remove and check next char at queue if freq is \
        appering more than one or not. We should only include char in answer if freq is less than 2.

        TC - O(N) and SC - O(N)
        */

        Map<Character, Integer> map = new HashMap<>();
        Queue<Character> q = new LinkedList<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            // Increase freq in map of character.
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }

            q.add(ch); // insert new char in the queue.

            // Remove char from queue if freq is more than 2
            while (!q.isEmpty() && map.get(q.peek()) >= 2) {
                q.poll();
            }

            // Prepare answer string builder.
            if (q.isEmpty()) {
                result.append('#');
            } else {
                result.append(q.peek());
            }

        }

        return result.toString();
    }
}
