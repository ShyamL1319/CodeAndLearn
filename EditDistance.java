/**
 * Date: 15/01/2024:17:27
 * User: shyamlal
 * Problem Description
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * Insert a character
 * Delete a character
 * Replace a character
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length(A), length(B) <= 450
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains a string, A.
 * The second argument of input contains a string, B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, representing the minimum number of steps required.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abad"
 * B = "abac"
 * Input 2:
 * <p>
 * A = "Anshuman"
 * B = "Antihuman
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Exlanation 1:
 * <p>
 * A = "abad" and B = "abac"
 * After applying operation: Replace d with c. We get A = B.
 * <p>
 * Explanation 2:
 * <p>
 * A = "Anshuman" and B = "Antihuman"
 * After applying operations: Replace s with t and insert i before h. We get A = B.
 */
public class EditDistance {
    int[][] dp;

    public static void main(String[] args) {
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("Anshuman", "Antihuman"));
    }

    public int editDistance(String A, String B, int i, int j) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 0;
        if (A.charAt(i) == B.charAt(j)) {
            ans = editDistance(A, B, i - 1, j - 1);//if both cahr equal, check prev char
        } else {
            int a = editDistance(A, B, i, j - 1);//Insert a char in A String
            int b = editDistance(A, B, i - 1, j - 1);//Replace a char in A string
            int c = editDistance(A, B, i - 1, j);//Delete a char in A String
            ans = Math.min(a, Math.min(b, c)) + 1;//each operation count one as one action. So, we'll find min  of them and add 1

        }
        dp[i][j] = ans;
        return ans;
    }

    public int minDistance(String A, String B) {
        int N = A.length();
        int M = B.length();
        dp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j] = -1;
            }
        }
        return editDistance(A, B, N - 1, M - 1);
    }
}
