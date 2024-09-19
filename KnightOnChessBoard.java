import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Date: 16/01/2024:07:04
 * User: shyamlal
 * Problem Description
 * Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
 * <p>
 * <p>
 * The above figure details the movements for a knight ( 8 possibilities ).
 * <p>
 * If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
 * <p>
 * NOTE: A knight cannot go out of the board.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A, B <= 500
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument of input contains an integer A.
 * The second argument of input contains an integer B.
 * The third argument of input contains an integer C.
 * The fourth argument of input contains an integer D.
 * The fifth argument of input contains an integer E.
 * The sixth argument of input contains an integer F.
 * <p>
 * <p>
 * <p>
 * Output Format
 * If it is possible to reach the destination point, return the minimum number of moves.
 * Else return -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 8
 * B = 8
 * C = 1
 * D = 1
 * E = 8
 * F = 8
 * Input 2:
 * <p>
 * A = 2
 * B = 4
 * C = 2
 * D = 1
 * E = 4
 * F = 4
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 6
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The size of the chessboard is 8x8, the knight is initially at (1, 1) and the knight wants to reach position (8, 8).
 * The minimum number of moves required for this is 6.
 * Explanation 2:
 * <p>
 * It is not possible to move knight to position (4, 4) from (2, 1)
 */
public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(knight(8, 8, 1, 1, 8, 8));
    }

    public static int knight(int A, int B, int C, int D, int E, int F) {
        boolean[][] visited = new boolean[A + 1][B + 1];
        int[][] dirs = new int[][]{{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{C, D, 0});

        while (!queue.isEmpty()) {
            int[] last = queue.remove();
            int i = last[0], j = last[1], cnt = last[2];
            if (i == E && j == F) {
                return cnt;
            }

            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x > 0 && y > 0 && x <= A && y <= B && !visited[x][y]) {
                    queue.add(new int[]{x, y, cnt + 1});
                    visited[x][y] = true;
                }
            }

        }

        return -1;
    }
}
