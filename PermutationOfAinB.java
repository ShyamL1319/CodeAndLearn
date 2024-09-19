/**
 * Date: 27/12/2023:10:00
 * User: shyamlal
 * Problem Description
 * You are given two strings, A and B, of size N and M, respectively.
 * <p>
 * You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N < M <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * Given two arguments, A and B of type String.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer, i.e., number of permutations of A present in B as a substring.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abc"
 * B = "abcbacabc"
 * Input 2:
 * <p>
 * A = "aca"
 * B = "acaa"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 5
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Permutations of A that are present in B as substring are:
 * 1. abc
 * 2. cba
 * 3. bac
 * 4. cab
 * 5. abc
 * So ans is 5.
 * Explanation 2:
 * <p>
 * Permutations of A that are present in B as substring are:
 * 1. aca
 * 2. caa
 */
public class PermutationOfAinB {
    public static void main(String[] args) {
        String A = "aca";
        String B = "acaa";
        System.out.println(solve(A, B));
    }

    public static int solve(String A, String B) {
        int count = 0;
        //store string A characters frequency in frequency array of size 26
        int[] freqA = new int[26];
        for (int i = 0; i < A.length(); i++) {
            freqA[A.charAt(i) - 'a']++;
        }
        //Interate through B and continue adding characters frequency of B string in freqB and check at any point if freqA and freqB is same
        int[] freqB = new int[26];
        for (int i = 0; i < B.length(); i++) {
            freqB[B.charAt(i) - 'a']++;
            //when i will be at index >=A.length, then remove leftmost char freq from freqB as we are sliding window by one char
            if (i >= A.length()) {
                freqB[B.charAt(i - A.length()) - 'a']--;
            }
            if (compare(freqA, freqB)) {
                count++;
            }
        }
        return count++;
    }

    private static boolean compare(int[] freqA, int[] freqB) {
        for (int i = 0; i < freqA.length; i++) {
            if (freqA[i] != freqB[i]) {
                return false;
            }

        }
        return true;

    }
}
