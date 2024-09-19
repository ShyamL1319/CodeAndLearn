import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 16/01/2024:06:16
 * User: shyamlal
 * Problem Description
 * There is a rectangle with left bottom as (0, 0) and right up as (x, y).
 * <p>
 * There are N circles such that their centers are inside the rectangle.
 * <p>
 * Radius of each circle is R. Now we need to find out if it is possible that we can move from (0, 0) to (x, y) without touching any circle.
 * <p>
 * Note : We can move from any cell to any of its 8 adjecent neighbours and we cannot move outside the boundary of the rectangle at any point of time.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= x , y, R <= 100
 * <p>
 * 1 <= N <= 1000
 * <p>
 * Center of each circle would lie within the grid
 * <p>
 * <p>
 * <p>
 * Input Format
 * 1st argument given is an Integer x , denoted by A in input.
 * <p>
 * 2nd argument given is an Integer y, denoted by B in input.
 * <p>
 * 3rd argument given is an Integer N, number of circles, denoted by C in input.
 * <p>
 * 4th argument given is an Integer R, radius of each circle, denoted by D in input.
 * <p>
 * 5th argument given is an Array A of size N, denoted by E in input, where A[i] = x cordinate of ith circle
 * <p>
 * 6th argument given is an Array B of size N, denoted by F in input, where B[i] = y cordinate of ith circle
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return YES or NO depending on weather it is possible to reach cell (x,y) or not starting from (0,0).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * x = 2
 * y = 3
 * N = 1
 * R = 1
 * A = [2]
 * B = [3]
 * Input 2:
 * <p>
 * x = 3
 * y = 3
 * N = 1
 * R = 1
 * A = [0]
 * B = [3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * NO
 * Output 2:
 * <p>
 * YES
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There is NO valid path in this case
 * Explanation 2:
 * <p>
 * There is many valid paths in this case.
 * One of the path is (0, 0) -> (1, 0) -> (2, 0) -> (3, 0) -> (3, 1) -> (3, 2) -> (3, 3).
 */
public class ValidPath {
    public static void main(String[] args) {
        int x = 3;
        int y = 3;
        int N = 1;
        int R = 1;
        int[] A = {0};
        int[] B = {3};
        System.out.println(solve(x, y, N, R, A, B));
    }
    //First built up graph by removing all those points which comes on or into the circle by 2 point formula and compare that distance with radius of circle. if distance (dis) is small or equal it means point either lie on circumference or inside the circle. 0 for all those (i,j) points which lie on the circle and rest points are set to 1. then check simple by apply bfs from (0,0) to (A,B) and before it just check 2 points (0,0) and (A,B) whether they are 0 or 1.  0 means not reachable and by both are 1 then their is a possibility of any path.

    public static String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] mat = new int[A + 1][B + 1];
        for (int i = 0; i <= A; i++) {
            for (int j = 0; j <= B; j++) {
                for (int k = 0; k < E.length; k++) {
                    int x = E[k], y = F[k];
                    int d = (x - i) * (x - i) + (y - j) * (y - j);
                    double dis = Math.sqrt(d);
                    if (dis <= D) {
                        mat[i][j] = 0;
                        break;
                    } else {
                        mat[i][j] = 1;
                    }
                }
            }
        }
        if (mat[0][0] == 0) return "NO";
        else if (mat[A][B] == 0) return "NO";

        if (bfs(0, 0, A, B, mat)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static boolean bfs(int i, int j, int A, int B, int[][] mat) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(i, j));
        mat[i][j] = 0;
        while (q.size() > 0) {
            pair curr = q.poll();
            int r = curr.i, c = curr.j;
            if (r == A && c == B) {
                return true;
            }

            if (r - 1 >= 0 && mat[r - 1][c] == 1) {
                q.add(new pair(r - 1, c));
                mat[r - 1][c] = 0;
            }
            if (c - 1 >= 0 && mat[r][c - 1] == 1) {
                q.add(new pair(r, c - 1));
                mat[r][c - 1] = 0;
            }
            if (r + 1 < mat.length && mat[r + 1][c] == 1) {
                q.add(new pair(r + 1, c));
                mat[r + 1][c] = 0;
            }
            if (c + 1 < mat[0].length && mat[r][c + 1] == 1) {
                q.add(new pair(r, c + 1));
                mat[r][c + 1] = 0;
            }
        }
        return false;
    }

    static class pair {
        int i;
        int j;

        public pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
