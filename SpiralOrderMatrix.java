/**
 * Problem Description
 * Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order and return the generated square matrix.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is integer A
 * <p>
 * <p>
 * Output Format
 * Return a 2-D matrix which consists of the elements added in spiral order.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * Input 2:
 * <p>
 * 2
 * Input 3:
 * <p>
 * 5
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [ [1] ]
 * Output 2:
 * <p>
 * [ [1, 2],
 * [4, 3] ]
 * Output 2:
 * <p>
 * [ [1,   2,  3,  4, 5],
 * [16, 17, 18, 19, 6],
 * [15, 24, 25, 20, 7],
 * [14, 23, 22, 21, 8],
 * [13, 12, 11, 10, 9] ]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Only 1 is to be arranged.
 * Explanation 2:
 * <p>
 * 1 --> 2
 * |
 * |
 * 4<--- 3
 * Explanation 3:
 */

public class SpiralOrderMatrix {
    public static void main(String[] args) {
        Solution<Integer> arrPrinter = new Solution<>();
        arrPrinter.printTwoDArray(generateSpralMatrix(3));
    }

    public static Integer[][] generateSpralMatrix(int A) {
        Integer[][] resMatrix = new Integer[A][A];
        int x = 1;
        int tr = 0, br = A - 1, lc = 0, rc = A - 1;
        while (x <= (A * A)) {

            for (int k = lc; k <= rc; k++) {
                resMatrix[tr][k] = x++;
            }

            tr++;

            for (int k = tr; k <= br; k++) {
                resMatrix[k][rc] = x++;
            }

            rc--;

            for (int k = rc; k >= lc; k--) {
                resMatrix[br][k] = x++;
            }

            br--;

            for (int k = br; k >= tr; k--) {
                resMatrix[k][lc] = x++;
            }

            lc++;

        }
        return resMatrix;
    }

}
