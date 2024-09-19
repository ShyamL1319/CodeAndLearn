import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Date: 17/12/2023:22:18
 * User: shyamlal
 * Problem Description
 * Given a set of distinct integers A, return all possible subsets.
 * <p>
 * NOTE:
 * <p>
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * Also, the subsets should be sorted in ascending ( lexicographic ) order.
 * The initial list is not necessarily sorted.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 16
 * INTMIN <= A[i] <= INTMAX
 * <p>
 * <p>
 * Input Format
 * First and only argument of input contains a single integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a vector of vectors denoting the answer.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [
 * []
 * [1]
 * ]
 * Output 2:
 * <p>
 * [
 * []
 * [1]
 * [1, 2]
 * [1, 2, 3]
 * [1, 3]
 * [2]
 * [2, 3]
 * [3]
 * ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * You can see that these are all possible subsets.
 * Explanation 2:
 * <p>
 * You can see that these are all possible subsets.
 */
public class Subsets {
    public static void main(String[] args) {
        int[] A = {9, -20, -11, -8, -4, 2, -12, 14, 1, -18};
//        Solution sl = new Solution();
        int[] B = {1, 2, 3};
        ArrayList<Integer> al = new ArrayList<>();
        for (int ele : A) {
            al.add(ele);
        }
        ArrayList<ArrayList<Integer>> ral = subsets(al);

        int[][] res = subsets(A);
        //System.out.println((res.length));
//        for(int i=0; i < res.length; i++){
//            System.out.print("[");
//            for(int j=0; j< res[i].length; j++){
//                System.out.print(res[i][j] + " ");
//            }
//        System.out.print("]");
//        System.out.println();
//        }

        for (int i = 0; i < ral.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < ral.get(i).size(); j++) {
                System.out.print(ral.get(i).get(j) + " ");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < Math.pow(2, A.size()); i++) {
            ArrayList<Integer> insideArr = new ArrayList<>();
            for (int j = 0; j < A.size(); j++) {
                if (((1 << j) & i) != 0) {
                    insideArr.add(A.get(j));
                }
            }
            arr.add(insideArr);
        }
        Collections.sort(arr, (ArrayList<Integer> first, ArrayList<Integer> second) -> {
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) < second.get(i))
                    return -1;
                if (first.get(i) > second.get(i))
                    return 1;
            }
            if (first.size() > second.size())
                return 1;
            return -1;
        });
        return arr;
    }

    public static int[][] subsets(int[] A) {

        Arrays.sort(A);

        int N = 1 << A.length;

        int[][] res = new int[N][];


        res[0] = new int[1];
        //res[0][0] = 0;

        for (int i = 1; i < N; i++) {
            ArrayList<Integer> tempRes = new ArrayList<>();
            int bit = i;
            for (int j = 0; j < A.length && bit > 0; j++) {
                if ((bit & 1) == 1) {
                    tempRes.add(A[j]);
                }
                bit = bit >> 1;
            }
            res[i] = new int[tempRes.size()];
            for (int k = 0; k < tempRes.size(); k++) {
                res[i][k] = tempRes.get(k);
            }
        }

        Arrays.sort(res, (o1, o2) -> {
            int minLength = o1.length < o2.length ? o1.length : o2.length;
            for (int i = 0; i < minLength; i++) {
                if (o1[i] < o2[i]) return -1;
                if (o1[i] > o2[i]) return 1;
            }
            if (o1.length > o2.length) return 1;
            return -1;
        });
        return res;
    }
}
