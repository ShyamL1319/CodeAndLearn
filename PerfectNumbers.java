import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 07/01/2024:23:58
 * User: shyamlal
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 * <p>
 * A Perfect Number has the following properties:
 * <p>
 * It comprises only 1 and 2.
 * The number of digits in a Perfect number is even.
 * It is a palindrome number.
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 22
 * Output 2:
 * <p>
 * 1111
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 2nd Perfect number.
 * Explanation 2:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Return the 3rd Perfect number.
 */
public class PerfectNumbers {
    public static void main(String[] args) {
        System.out.println(solve(2));
    }

    public static String solve(int A) {
        Queue<String> q = new LinkedList<>();
        // A=4 12|21 = 1221
        q.add("1");
        q.add("2");
        for (int i = 1; i < A; i++) {
            String ele = q.peek();
            q.offer(ele + "1");
            q.offer(ele + "2");
            q.poll();
        }
        StringBuilder sb = new StringBuilder(q.peek());
        sb.reverse();
        String ans = q.poll() + sb;
        return ans;
    }
}
