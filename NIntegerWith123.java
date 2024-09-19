import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 07/01/2024:23:48
 * User: shyamlal
 * Problem Description
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 * <p>
 * NOTE: All the A integers will fit in 32-bit integers.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 29500
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 2, 3, 11, 12, 13, 21]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 * <p>
 * Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */
public class NIntegerWith123 {
    public static void main(String[] args) {
        int[] res = solve(7);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int A) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");
        q.add("3");
        int[] res = new int[A];
        int j = 0;
        for (int i = 1; i <= A; i++) {
            String ele = q.peek();
            q.offer(ele + "1");
            q.offer(ele + "2");
            q.offer(ele + "3");
            res[j] = Integer.parseInt(q.poll());
            j++;
        }
        return res;
    }
}
