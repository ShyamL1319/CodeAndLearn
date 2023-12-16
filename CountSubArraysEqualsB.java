import java.util.HashMap;

/**
 * Date: 16/12/2023:22:52
 * User: shyamlal
 */
public class CountSubArraysEqualsB {
    public static void main(String[] args) {
        int[] arr = {-4, 1, 2, 3, -3, 1, 1, 1};
        int B = 3;
        System.out.println(countSubArraysToB(arr, B));
    }

    public static int countSubArraysToB(int[] A, int B) {
        int n = A.length;
        int psum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            psum = psum + A[i];
            count += map.getOrDefault(psum - B, 0);
            map.put(psum, map.getOrDefault(psum, 0) + 1);
        }
        return count;
    }
}
