import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:12:44
 * User: shyamlal
 * Problem Description
 * You are given an array A of integers that represent the lengths of ropes.
 * <p>
 * You need to connect these ropes into one rope. The cost of joining two ropes equals the sum of their lengths.
 * <p>
 * Find and return the minimum cost to connect these ropes into one rope.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum cost to connect these ropes into one rope.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 33
 * Output 2:
 * <p>
 * 182
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Given array A = [1, 2, 3, 4, 5].
 * Connect the ropes in the following manner:
 * 1 + 2 = 3
 * 3 + 3 = 6
 * 4 + 5 = 9
 * 6 + 9 = 15
 * <p>
 * So, total cost  to connect the ropes into one is 3 + 6 + 9 + 15 = 33.
 * Explanation 2:
 * <p>
 * Given array A = [5, 17, 100, 11].
 * Connect the ropes in the following manner:
 * 5 + 11 = 16
 * 16 + 17 = 33
 * 33 + 100 = 133
 * <p>
 * So, total cost  to connect the ropes into one is 16 + 33 + 133 = 182.
 */
public class ConnectRopes {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(solve(A));
    }

    public static int solve(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(A[i]);
        }

        int sum = 0;

        while (pq.size() > 1) { // in last we have 1 element in queue so we ignore this element
            int a = pq.poll();
            int b = pq.poll();

            int ans = a + b;
            pq.add(ans);

            sum = sum + ans;
        }

        return sum;
    }
}
