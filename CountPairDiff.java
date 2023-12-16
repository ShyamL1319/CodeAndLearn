import java.util.HashMap;

/**
 * Date: 15/12/2023:10:36
 * User: shyamlal
 */
public class CountPairDiff {
    public static void main(String[] args) {
        int A = 1;
        int[] B = {1, 2, 1, 2};// {3, 5, 1, 2};
        System.out.println(pairDiffCount(B, A));
    }

    public static int pairDiffCount(int[] A, int B) {
        long count = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            count = count + hm.getOrDefault(A[i] + B, 0);
            count = count + hm.getOrDefault(A[i] - B, 0);
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
        }
        return (int) count % 1000000007;
    }
}
