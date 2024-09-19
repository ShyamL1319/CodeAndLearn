import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 29/12/2023:23:36
 * User: shyamlal
 * Problem Description
 * Given an array A of N strings, return all groups of strings that are anagrams.
 * <p>
 * Represent a group by a list of integers representing the index(1-based) in the original list. Look at the sample case for clarification.
 * <p>
 * NOTE: Anagram is a word, phrase, or name formed by rearranging the letters, such as 'spar', formed from 'rasp'.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 104
 * <p>
 * 1 <= |A[i]| <= 104
 * <p>
 * Each string consists only of lowercase characters.
 * <p>
 * The sum of the length of all the strings doesn't exceed 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a two-dimensional array where each row describes a group.
 * <p>
 * Note:
 * <p>
 * Ordering of the result :
 * You should not change the relative ordering of the strings within the group suppose within a group containing A[i] and A[j], A[i] comes before A[j] if i < j.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [cat, dog, god, tca]
 * Input 2:
 * <p>
 * A = [rat, tar, art]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [ [1, 4],
 * [2, 3] ]
 * Output 2:
 * <p>
 * [ [1, 2, 3] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * "cat" and "tca" are anagrams which correspond to index 1 and 4 and "dog" and "god" are another set of anagrams which correspond to index 2 and 3.
 * The indices are 1 based ( the first element has index 1 instead of index 0).
 * Explanation 2:
 * <p>
 * All three strings are anagrams.
 */
public class Anagram {
    public static void main(String[] args) {
        List<String> A = new ArrayList<>();

        A.add("cat");
        A.add("dog");
        A.add("god");
        A.add("tca");

        System.out.println(anagrams(A));

    }

    public static ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            String s = A.get(i);
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String str = new String(ch);
            if (!result.containsKey(str)) {
                result.put(str, new ArrayList<Integer>());
            }
            result.get(str).add(i + 1);
        }
        return new ArrayList(result.values());
    }
}
