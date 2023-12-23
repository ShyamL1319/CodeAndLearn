/**
 * Date: 22/12/2023:09:21
 * User: shyamlal
 * Problem Description
 * You are given three positive integers, A, B, and C.
 * <p>
 * Any positive integer is magical if divisible by either B or C.
 * <p>
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * Note: Ensure to prevent integer overflow while calculating.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * 2 <= B, C <= 40000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A.
 * <p>
 * The second argument given is an integer B.
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * A = 4
 * B = 2
 * C = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1st magical number is 2.
 * Explanation 2:
 * <p>
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {
    public static void main(String[] args) {
        System.out.println(solve(1, 2, 3));
        System.out.println(solve(4, 2, 3));
    }

    public static int solve(int A, int B, int C) {
        long l = Math.min(B, C);
        long h = A * l;
        long lcm = getLCM(B, C);
        long mod = 1000000007;
        long ans = 0;
        while (l <= h) {
            long m = (l + h) / 2;
            if ((m / B) + (m / C) - (m / lcm) == A) {
                ans = m;
                h = m - 1;
            } else if ((m / B) + (m / C) - (m / lcm) > A) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        ans %= mod;
        return (int) ans;
    }

    public static int getLCM(int a, int b) {
        int x = a;
        int y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        int gcd = x;

        int lcm = (a * b) / gcd;
        
        return lcm;
    }
}
