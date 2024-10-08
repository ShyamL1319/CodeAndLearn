package CarryForward;

/**
 * Date: 19/09/2024:07:28
 * User: shyamlal
 * Problem Description
 * You have given a string A having Uppercase English letters.
 *
 * You have to find how many times subsequence "AG" is there in the given string.
 *
 * NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
 *
 *
 *
 * Problem Constraints
 * 1 <= length(A) <= 105
 *
 *
 *
 * Input Format
 * First and only argument is a string A.
 *
 *
 *
 * Output Format
 * Return an integer denoting the answer.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = "ABCGAG"
 * Input 2:
 *
 *  A = "GAB"
 *
 *
 * Example Output
 * Output 1:
 *
 *  3
 * Output 2:
 *
 *  0
 */
public class SpecialSeqI {
    public static void main(String[] args) {
        String s = "ABCGAG";

        int count =0;
        int ans =0;
        int modulo = 1000 * 1000 * 1000 + 7;

        for(int i =0; i<s.length(); i++){
            if(s.charAt(i) == 'A'){
                count++;
            }

            if(s.charAt(i) == 'G'){
                ans += count;

                ans %= modulo;
            }
        }

        System.out.println(ans);
        System.out.println(solve(s));
    }


    public static int solve(String A) {
        int n = A.length(), ans = 0, MOD = 1000*1000*1000 + 7;
        int cnt_G[] = new int[n], count = 0;

        //Suffix count of G
        for(int i = n - 1 ; i >= 0 ; i--){
            if(A.charAt(i) == 'G')
                count = count + 1;
            cnt_G[i] = count;
        }

        // traverse the string again from beginning
        for(int i = 0; i < n; i++){
            // if current character is "A" then add number of G's after that
            if(A.charAt(i) == 'A') {
                ans = ans + cnt_G[i];
                ans = ans % MOD;
            }
        }
        return ans;
    }
}
