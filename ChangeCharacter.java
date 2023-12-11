import java.util.Arrays;

/**
 * Date: 12/12/2023:02:14
 * User: shyamlal
 * Problem Description
 * You are given a string A of size N consisting of lowercase alphabets.
 * <p>
 * You can change at most B characters in the given string to any other lowercase alphabet such that the number of distinct characters in the string is minimized.
 * <p>
 * Find the minimum number of distinct characters in the resulting string.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * <p>
 * 0 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is a string A.
 * <p>
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of distinct characters in the string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * A = "abcabbccd"
 * B = 3
 * <p>
 * <p>
 * <p>
 * Example Output
 * 2
 * <p>
 * <p>
 * <p>
 * Example Explanation
 * We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 * So the minimum number of distinct character will be 2.
 */
public class ChangeCharacter {
    public static void main(String[] args) {
        String string = "abcabbccde";
        int B = 4;
        System.out.println(minmumDistinctCharacter(string, B));
    }

    public static int minmumDistinctCharacter(String A, int B) {
        int[] charInt = new int[26];

        for (int i = 0; i < A.length(); i++) {
            charInt[(int) A.charAt(i) - 'a'] += 1;
        }

        Arrays.sort(charInt);

        int sum = 0;

        for (int i = 0; i < 26; i++) {
            if (charInt[i] == 0) {
                continue;
            } else {
                sum += charInt[i];
                if (sum > B) {
                    return (25 - i + 1);
                } else {
                    continue;
                }
            }
        }
        return 1;
    }
}
