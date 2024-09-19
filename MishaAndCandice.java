import java.util.PriorityQueue;

/**
 * Date: 14/01/2024:14:03
 * User: shyamlal
 * Problem Description
 * Misha loves eating candies. She has been given N boxes of Candies.
 * <p>
 * She decides that every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
 * Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?
 * <p>
 * NOTE 1: If a box has an odd number of candies then Misha will eat the floor(odd / 2).
 * <p>
 * NOTE 2: The same box will not be chosen again.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i] <= 105
 * <p>
 * 1 <= B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
 * The second argument is B, the maximum number of candies Misha like in a box.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the number of candies Misha will eat.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 2, 3]
 * B = 4
 * Input 2:
 * <p>
 * A = [1, 2, 1]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 * 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 * She will not eat from the 3rd box as now it has candies greater than B.
 * So the number of candies Misha eat is 2.
 * Explanation 2:
 * <p>
 * 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 * 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 * She will not eat from the 2nd box as now it has candies greater than B.
 * So the number of candies Misha eat is 1.
 */
public class MishaAndCandice {
    public static void main(String[] args) {
        int[] A = {3, 2, 3};
        System.out.println(solve(A, 4));
    }

    public static int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue();//min heap
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            pq.add(A[i]);
        }
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr > B) {
                break;
            }
            int currHalf = curr / 2;
            ans += currHalf;
            if (!pq.isEmpty()) {
                int currNext = pq.poll();
                int sum = currNext + curr - currHalf;//adding remaining candies to the next min box
                pq.add(sum);
            }
        }
        return ans;
    }
}
