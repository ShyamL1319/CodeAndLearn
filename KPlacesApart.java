import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:00:45
 * User: shyamlal
 * Problem Description
 * N people having different priorities are standing in a queue.
 * <p>
 * The queue follows the property that each person is standing at most B places away from its position in the sorted queue.
 * <p>
 * Your task is to sort the queue in the increasing order of priorities.
 * <p>
 * NOTE:
 * <p>
 * No two persons can have the same priority.
 * Use the property of the queue to sort the queue with complexity O(NlogB).
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer array A representing the priorities and initial order of N persons.
 * The second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array representing the sorted queue.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 40, 2, 3]
 * B = 2
 * Input 2:
 * <p>
 * A = [2, 1, 17, 10, 21, 95]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 40]
 * Output 2:
 * <p>
 * [1, 2, 10, 17, 21, 95]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Given array A = [1, 40, 2, 3]
 * After sorting, A = [1, 2, 3, 40].
 * We can see that difference between initial position of elements amd the final position <= 2.
 * Explanation 2:
 * <p>
 * After sorting, the array becomes [1, 2, 10, 17, 21, 95].
 */
public class KPlacesApart {
    public static void main(String[] args) {
        int[] A = {2, 1, 17, 10, 21, 95};
        int B = 2;
        int[] res = solve(A, B);
        for (int ele : res) {
            System.out.print(ele + ", ");
        }
    }

    public static int[] solve(int[] A, int B) {
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] ans = new int[n];
        //adding element in PriorityQueue
        for (int i = 0; i < n; i++) {
            pq.add(A[i]);
        }

        for (int i = 0; i < n; i++) {
            ans[i] = pq.peek();
            pq.remove();
        }
        return ans;
    }
}
