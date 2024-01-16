import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 16/01/2024:06:57
 * User: shyamlal
 * Problem Description
 * Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
 * <p>
 * 1 represents a wall in a matrix and 0 represents an empty location in a wall.
 * <p>
 * There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
 * <p>
 * Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
 * <p>
 * Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N, M <= 100
 * <p>
 * 0 <= A[i] <= 1
 * <p>
 * 0 <= B[i][0], C[i][0] < N
 * <p>
 * 0 <= B[i][1], C[i][1] < M
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer matrix A.
 * <p>
 * The second argument given is an array of integer B.
 * <p>
 * The third argument if an array of integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer, the minimum distance required to reach destination
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [ [0, 0],
 * [0, 0] ]
 * B = [0, 0]
 * C = [0, 1]
 * Input 2:
 * <p>
 * A = [ [0, 1],
 * [1, 0] ]
 * B = [0, 0]
 * C = [1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Go directly from start to destination in distance 1.
 * Explanation 2:
 * <p>
 * It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
 */
public class ShortestDistanceInMaze {
    public static void main(String[] args) {
        int[][] A = {
                {0, 0},
                {0, 0},
        };
        int[] B = {0, 0};
        int[] C = {0, 1};
        ShortestDistanceInMaze noi = new ShortestDistanceInMaze();
        System.out.println(noi.solve(A, B, C));
    }

    public int solve(int[][] A, int[] B, int[] C) {
        boolean[][] visited = new boolean[A.length][A[0].length];
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(B[0], B[1], 0));

        while (!q.isEmpty()) {
            Node curr = q.remove();
            if (curr.row == C[0] && curr.col == C[1]) {
                return curr.step;
            }
            for (int i = 0; i < 4; i++) {
                int newRow = curr.row;
                int newCol = curr.col;
                int newStep = curr.step;

                while (newRow >= 0 && newRow < A.length && newCol >= 0 && newCol < A[0].length && A[newRow][newCol] == 0) {
                    newRow += dx[i];
                    newCol += dy[i];
                    newStep++;
                }
                newRow -= dx[i];
                newCol -= dy[i];
                newStep--;
                if (!visited[newRow][newCol]) {
                    q.add(new Node(newRow, newCol, newStep));
                    visited[newRow][newCol] = true;
                }
            }
        }
        return -1;
    }

    class Node {
        int row;
        int col;
        int step;

        Node(int r, int c, int s) {
            row = r;
            col = c;
            step = s;
        }
    }
}
