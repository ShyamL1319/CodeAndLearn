import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * You are given an integer array A of length N comprising of 0's & 1's, and an integer B.
 * <p>
 * You have to tell all the indices of array A that can act as a center of 2 * B + 1 length 0-1 alternating subarray.
 * <p>
 * A 0-1 alternating array is an array containing only 0's & 1's, and having no adjacent 0's or 1's. For e.g. arrays [0, 1, 0, 1], [1, 0] and [1] are 0-1 alternating, while [1, 1] and [0, 1, 0, 0, 1] are not.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 103
 * <p>
 * A[i] equals to 0 or 1.
 * <p>
 * 0 <= B <= (N - 1) / 2
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array containing indices(0-based) in sorted order. If no such index exists, return an empty integer array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 0, 1, 0, 1]
 * B = 1
 * Input 2:
 * <p>
 * A = [0, 0, 0, 1, 1, 0, 1]
 * B = 0
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [0, 1, 2, 3, 4, 5, 6]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Index 1 acts as a centre of alternating sequence: [A0, A1, A2]
 * Index 2 acts as a centre of alternating sequence: [A1, A2, A3]
 * Index 3 acts as a centre of alternating sequence: [A2, A3, A4]
 * Explanation 2:
 * <p>
 * Each index in the array acts as the center of alternating sequences of lengths 1.
 */
public class AlternatingSubArrays {
    public static void main(String[] args) {
        int[] A = {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0};
        int B = 4;
        int[] result = alternatingSubarrays(A, B);
        System.out.println(Arrays.toString(result));
    }


    public static int[] alternatingSubarrays(int[] A, int B) {
        int len = A.length;
        List<Integer> res = new ArrayList<>();
        if (B == 0) {
            for (int i = 0; i < len; i++) {
                res.add(i);
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
        int K = 2 * B + 1;
        for (int i = 0; i <= (len - K); i++) {
            int start = i;
            int end = i + K;
            boolean ulternating = true;

            for (int k = start + 1; k < end; k++) {
                if (A[k - 1] == A[k]) {
                    ulternating = false;
                    break;
                }
            }
            if (ulternating) res.add(start + B);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
