import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:13:38
 * User: shyamlal
 * Problem Description
 * Given an integer array A of size N.
 * <p>
 * You have to find the product of the three largest integers in array A from range 1 to i, where i goes from 1 to N.
 * <p>
 * Return an array B where B[i] is the product of the largest 3 integers in range 1 to i in array A. If i < 3, then the integer at index i in B should be -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 0 <= A[i] <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array B. B[i] denotes the product of the largest 3 integers in range 1 to i in array A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [10, 2, 13, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [-1, -1, 6, 24, 60]
 * Output 2:
 * <p>
 * [-1, -1, 260, 520]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 1 * 2 * 3 = 6
 * For i = 4, ans = 2 * 3 * 4 = 24
 * For i = 5, ans = 3 * 4 * 5 = 60
 * <p>
 * So, the output is [-1, -1, 6, 24, 60].
 * <p>
 * Explanation 2:
 * <p>
 * For i = 1, ans = -1
 * For i = 2, ans = -1
 * For i = 3, ans = 10 * 2 * 13 = 260
 * For i = 4, ans = 10 * 13 * 4 = 520
 * <p>
 * So, the output is [-1, -1, 260, 520].
 */
class Maxheapcomparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        if (o1 < o2)
            return 1;
        else if (o1 > o2)
            return -1;
        else
            return 0;
    }

}

public class ProductOf3 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] res = solve(A);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Maxheapcomparator());
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            pq.offer(A[i]);
            if (pq.size() < 3)
                ans[i] = -1;
            else if (pq.size() >= 3) {
                int x = pq.poll();
                int y = pq.poll();
                int z = pq.poll();
                int prod = x * y * z;
                ans[i] = prod;
                pq.offer(x);
                pq.offer(y);
                pq.offer(z);
            }
        }
        return ans;
    }
}
