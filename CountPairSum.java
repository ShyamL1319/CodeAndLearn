import java.util.HashMap;

/**
 * Date: 15/12/2023:09:46
 * User: shyamlal
 * <p>
 * Problem Description
 * You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j.
 * <p>
 * Since the answer can be very large, return the remainder after dividing the count with 109+7.
 * <p>
 * Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * <p>
 * Input Format
 * First argument A is an array of integers and second argument B is an integer.
 * <p>
 * <p>
 * Output Format
 * Return an integer.
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 5, 1, 2]
 * B = 8
 * Input 2:
 * <p>
 * A = [1, 2, 1, 2]
 * B = 3
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * Example 1:
 * <p>
 * The only pair is (1, 2) which gives sum 8
 * Example 2:
 * <p>
 * The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4).
 */
public class CountPairSum {
    public static void main(String[] args) {
        int A = 3;
        Integer[] B = {1, 2, 1, 2};// {3, 5, 1, 2};//
        //System.out.println(checkPairSum(A, B));

        System.out.println(countPairSum(B, A));
    }

    public static Integer countPairSum(Integer[] A, int B) {
        int count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int target = B - A[i];
            count = count + hm.getOrDefault(target, 0);
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return count % 1000000007;
    }
}
