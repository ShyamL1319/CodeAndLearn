import java.util.HashMap;

/**
 * Date: 15/12/2023:08:33
 * User: shyamlal
 * Problem Description
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * <p>
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * <p>
 * NOTE: if B > N, return an empty array.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 1, 3, 4, 3]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 1, 2, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 3, 3, 2]
 * Output 2:
 * <p>
 * [1, 1, 1, 1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A=[1, 2, 1, 3, 4, 3] and B = 3
 * All windows of size B are
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 * So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 * <p>
 * Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class DistinctNumberInWindow {
    public static void main(String[] args) {
        Solution<Integer> sol = new Solution<>();
        Integer[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        sol.printOneDArray(dNum(A, B));
    }

    public static Integer[] dNum(Integer[] A, int B) {
        if (B > A.length) return new Integer[0];
        //Using HashMap and sliding window together
        Integer[] ans = new Integer[A.length - B + 1];
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < B; i++) {
            if (hm.containsKey(A[i])) {
                hm.put(A[i], hm.get(A[i]) + 1);
            } else {
                hm.put(A[i], 1);
            }
        }
        ans[0] = hm.size();
        int s = 1, e = B;
        while (e < A.length) {
            hm.put(A[s - 1], hm.get(A[s - 1]) - 1);
            if (hm.get(A[s - 1]) == 0) hm.remove(A[s - 1]);
            if (hm.containsKey(A[e])) {
                hm.put(A[e], hm.get(A[e]) + 1);
            } else hm.put(A[e], 1);
            ans[s] = hm.size();
            s++;
            e++;
        }
        return ans;
    }
}
