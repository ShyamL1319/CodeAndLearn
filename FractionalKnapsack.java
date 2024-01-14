import java.util.Arrays;
import java.util.Comparator;

/**
 * Date: 14/01/2024:15:20
 * User: shyamlal
 * roblem Description
 * Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
 * <p>
 * Also given an integer C which represents knapsack capacity.
 * <p>
 * Find out the maximum total value that we can fit in the knapsack. If the maximum total value is ans, then return ⌊ans × 100⌋ , i.e., floor of (ans × 100).
 * <p>
 * NOTE:
 * <p>
 * You can break an item for maximizing the total value of the knapsack
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 1 <= A[i], B[i] <= 103
 * <p>
 * 1 <= C <= 103
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N denoting the values on N items.
 * <p>
 * Second argument is an integer array B of size N denoting the weights on N items.
 * <p>
 * Third argument is an integer C denoting the knapsack capacity.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting the maximum total value of A such that sum of the weights of this subset is smaller than or equal to C.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [60, 100, 120]
 * B = [10, 20, 30]
 * C = 50
 * Input 2:
 * <p>
 * A = [10, 20, 30, 40]
 * B = [12, 13, 15, 19]
 * C = 10
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 24000
 * Output 2:
 * <p>
 * 2105
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Taking the full items with weight 10 and 20 and 2/3 of the item with weight 30 will give us
 * the maximum value i.e 60 + 100 + 80 = 240. So we return 24000.
 * Explanation 2:
 * <p>
 * Taking 10/19 the fourth item gives us the maximum value i.e. 21.0526. So we return 2105.
 */
public class FractionalKnapsack {
    Comparator<Pair> comp = new Comparator<Pair>() {
        @Override
        public int compare(Pair A, Pair B) {
            if (A.vpw < B.vpw) return -1;
            if (A.vpw > B.vpw) return 1;
            return 0;
        }
    };

    public static void main(String[] args) {
        int[] A = {60, 100, 120};
        int[] B = {10, 20, 30};
        int C = 50;
        FractionalKnapsack fk = new FractionalKnapsack();
        System.out.println(fk.solve(A, B, C));

    }

    public int solve(int[] A, int[] B, int C) {

        int N = A.length;
        Pair[] arr = new Pair[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Pair(A[i], B[i]);
        }

        Arrays.sort(arr, comp);
        double ans = 0;
        for (int i = N - 1; i >= 0; i--) {
            Pair p = arr[i];
            if (p.wt <= C) {
                ans = ans + p.val;
                C = C - p.wt;
            } else {
                ans = ans + (C * p.vpw);
                break;
            }
        }
        return (int) (ans * 1000) / 10;

    }

    public class Pair {
        int val;
        int wt;
        double vpw;

        public Pair(int val, int wt) {
            this.val = val;
            this.wt = wt;
            this.vpw = ((1.0 * this.val) / this.wt);
        }
    }
}
