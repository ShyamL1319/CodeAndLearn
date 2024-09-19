/**
 * Given a binary string A. It is allowed to do at most one swap between any 0 and 1. Find and return the length of the longest consecutive 1’s that can be achieved.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is string A.
 * Output Format
 * <p>
 * Return the length of the longest consecutive 1’s that can be achieved.
 * Constraints
 * <p>
 * 1 <= length of string <= 1000000
 * A contains only characters 0 and 1.
 * For Example
 * <p>
 * Input 1:
 * A = "111000"
 * Output 1:
 * 3
 * <p>
 * Input 2:
 * A = "111011101"
 * Output 2:
 * 7
 */


public class LongestConsecutive1s {
    public static void main(String[] args) {
        String input = "1101101111";
        System.out.println(solve(input));
    }

    public static int solve(String A) {

        char[] chrArray = A.toCharArray();
        int N = A.length();
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < N; i++) {
            temp = i;
            ans += 1;
            if (chrArray[i] == '0') {
                ans -= 1;
                break;
            }
        }
        for (int i = temp; i < N; i++) {
            int currCons = 0;
            int lLeft = 0;
            int rLeft = N - 1;
            if (chrArray[i] == '1') continue;

            for (int k = i - 1; k >= 0; k--) {
                if (chrArray[k] == '1') {
                    currCons += 1;
                } else {
                    lLeft = k;
                    break;
                }
            }

            for (int k = i + 1; k < N; k++) {
                if (chrArray[k] == '1') {
                    currCons += 1;
                } else {
                    rLeft = k;
                    break;
                }
            }

            int replaceFound = 0;

            for (int k = lLeft - 1; k >= 0; k--) {
                if (chrArray[k] == '1') {
                    replaceFound = 1;
                    break;
                }
            }

            if (replaceFound == 0) {
                for (int k = rLeft + 1; k < N; k++) {
                    if (chrArray[k] == '1') {
                        replaceFound = 1;
                        break;
                    }
                }
            }

            ans = Math.max(ans, currCons + replaceFound);
        }
        return ans;
    }
}
