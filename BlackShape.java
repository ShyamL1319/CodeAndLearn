/**
 * Date: 16/01/2024:06:38
 * User: shyamlal
 * Problem Description
 * Given character matrix A of dimensions N×M consisting of O's and X's, where O = white, X = black.
 * <p>
 * Return the number of black shapes. A black shape consists of one or more adjacent X's (diagonals not included)
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 1000
 * <p>
 * A[i][j] = 'X' or 'O'
 * <p>
 * <p>
 * <p>
 * Input Format
 * The First and only argument is character matrix A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a single integer denoting number of black shapes.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [ [X, X, X], [X, X, X], [X, X, X] ]
 * Input 2:
 * <p>
 * A = [ [X, O], [O, X] ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * All X's belong to single shapes
 * Explanation 2:
 * <p>
 * Both X's belong to different shapes
 */
public class BlackShape {
    public static void main(String[] args) {
        String[][] a = {
                {"X", "X", "X"},
                {"X", "X", "X"},
                {"X", "X", "X"},
        };
        BlackShape bs = new BlackShape();
        System.out.println(bs.black(a[0]));
    }

    public void dfs(int i, int j, char[][] charArr, boolean[][] visited) {
        int n = charArr.length;
        int m = charArr[0].length;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if ((x >= 0 && x < n) && (y >= 0 && y < m) && !visited[x][y] && charArr[x][y] == 'X') {
                visited[x][y] = true;
                dfs(x, y, charArr, visited);
            }
        }
    }

    public int black(String[] A) {
        int n = A.length;
        int m = A[0].length();
        int ans = 0;
        char[][] charArr = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                charArr[i][j] = A[i].charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = false;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (charArr[i][j] == 'X' && !visited[i][j]) {
                    dfs(i, j, charArr, visited);
                    ans++;
                }
            }
        }
        return ans;
    }
}
