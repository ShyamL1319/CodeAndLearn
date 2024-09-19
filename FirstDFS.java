import java.util.ArrayList;

/**
 * Date: 16/01/2024:05:58
 * User: shyamlal
 * Problem Description
 * You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
 * <p>
 * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
 * <p>
 * B C : query to find whether B is reachable from C.
 * <p>
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
 * <p>
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
 * <p>
 * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is vector A
 * <p>
 * Second argument is integer B
 * <p>
 * Third argument is integer C
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if reachable, 0 otherwise.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 2]
 * B = 1
 * C = 2
 * Input 2:
 * <p>
 * A = [1, 1, 2]
 * B = 2
 * C = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
 * Explanation 2:
 * <p>
 * Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
 */
public class FirstDFS {
    public static void main(String[] args) {
        int[] A = {1, 1, 2};
        int B = 1;
        int C = 2;
        FirstDFS fdfs = new FirstDFS();
        System.out.println(fdfs.solve(A, B, C));
    }

    public int solve(int[] A, final int B, final int C) {
        ArrayList<Integer>[] graph = new ArrayList[A.length + 1];
        for (int j = 0; j <= A.length; j++) {
            graph[j] = new ArrayList<Integer>();
        }
        for (int i = 1; i < A.length; i++) {
            int u = A[i];
            int v = i + 1;
            graph[u].add(v);
            // System.out.println(graph[u]);
        }

        boolean[] visited = new boolean[A.length + 1];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        dfs(graph, C, visited);
        if (!visited[B]) {
            return 0;
        }
        return 1;
    }

    public void dfs(ArrayList<Integer>[] graph, int s, boolean[] visited) {
        visited[s] = true;
        for (int v : graph[s]) {
            if (!visited[v]) {
                dfs(graph, v, visited);
            }
        }
    }
}
