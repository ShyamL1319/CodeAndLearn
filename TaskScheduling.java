import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 08/01/2024:00:32
 * User: shyamlal
 * Problem Description
 * A CPU has N tasks to be performed. It is to be noted that the tasks have to be completed in a specific order to avoid deadlock. In every clock cycle, the CPU can either perform a task or move it to the back of the queue. You are given the current state of the scheduler queue in array A and the required order of the tasks in array B.
 * <p>
 * Determine the minimum number of clock cycles to complete all the tasks.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 1000
 * 1 <= A[i], B[i] <= N
 * <p>
 * <p>
 * Input Format
 * First argument consist of integer array A.
 * Second argument consist of integer array B.
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the minimum number of clock cycles required to complete all the tasks.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 3, 1, 5, 4]
 * B = [1, 3, 5, 4, 2]
 * Input 2:
 * <p>
 * A = [1]
 * B = [1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * According to the order array B task 1 has to be performed first, so the CPU will move tasks 2 and 3 to the end of the queue (in 2 clock cycles).
 * Total clock cycles till now = 2
 * Now CPU will perform task 1.
 * Total clock cycles till now = 3
 * Now, queue becomes [5, 4, 2, 3]
 * Now, CPU has to perform task 3. So it moves tasks 5, 4, and 2 to the back one-by-one.
 * Total clock cycles till now = 6
 * Now all the tasks in the queue are as in the required order so the CPU will perform them one-by-one.
 * Total clock cycles = 10
 * Explanation 2:
 * <p>
 * Directly task 1 is completed.
 */
public class TaskScheduling {
    public static void main(String[] args) {
        int[] A = {2, 3, 1, 5, 4};
        int[] B = {1, 3, 5, 4, 2};
        System.out.println(solve(A, B));
    }

    public static int solve(int[] A, int[] B) {
        int ans = 0;
        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            qu.add(A[i]);
        }

        for (int i = 0; i < B.length; i++) {
            int ele = B[i];

            while (!qu.isEmpty() && ele != qu.peek()) {
                int num = qu.poll();
                qu.add(num);
                ans++;
            }
            qu.poll();
            ans++;
        }
        return ans;
    }
}
