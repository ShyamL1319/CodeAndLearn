import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Date: 17/01/2024:23:08
 * User: shyamlal
 * Problem Description
 * Given an directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * <p>
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * <p>
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexographically smallest one.
 * <p>
 * Ordering (a, b, c) is said to be lexographically smaller than ordering (e, f, g) if a < e or if(a==e) then b < f and so on.
 * <p>
 * NOTE:
 * <p>
 *
 * There are no self-loops in the graph.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= A <= 104
 * <p>
 * 1 <= M <= min(100000,A*(A-1))
 * <p>
 * 1 <= B[i][0], B[i][1] <= A
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A representing the number of nodes in the graph.
 * <p>
 * The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a one-dimensional array denoting the topological ordering of the graph and it it doesn't exist then return empty array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 6
 * B = [  [6, 3]
 * [6, 1]
 * [5, 1]
 * [5, 2]
 * [3, 4]
 * [4, 2] ]
 * Input 2:
 * <p>
 * A = 3
 * B = [  [1, 2]
 * [2, 3]
 * [3, 1] ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [5, 6, 1, 3, 4, 2]
 * Output 2:
 * <p>
 * []
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The given graph contain no cycle so topological ordering exists which is [5, 6, 1, 3, 4, 2]
 * Explanation 2:
 * <p>
 * The given graph contain cycle so topological ordering not possible we will return empty array.
 */
public class TopologicalSort {
    public static void main(String[] args) {

    }

    public static ArrayList<ArrayList<Integer>> createAdjencyList(int A, int[][] B) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int src = B[i][0];
            int des = B[i][1];
            adj.get(src).add(des);
        }

        return adj;

    }

    public static int[] createIndegreeArray(int A, ArrayList<ArrayList<Integer>> adj) {

        int[] id = new int[A + 1];

        for (int i = 0; i <= A; i++) {
            ArrayList<Integer> nbrs = adj.get(i);
            for (int j = 0; j < nbrs.size(); j++) {
                int nbr = nbrs.get(j);
                id[nbr] = id[nbr] + 1;
            }
        }

        return id;
    }

    public int[] solve(int A, int[][] B) {
        boolean isAns = false;
        ArrayList<ArrayList<Integer>> adj = createAdjencyList(A, B);
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int[] id = createIndegreeArray(A, adj);

        for (int i = 1; i <= A; i++) {
            if (id[i] == 0) {
                q.add(i);
            }
        }

        int index = 0;
        int[] ans = new int[A];
        while (q.size() > 0) {
            isAns = true;
            int ele = q.poll();
            ans[index++] = ele;
            ArrayList<Integer> nbrs = adj.get(ele);
            for (int i = 0; i < nbrs.size(); i++) {
                int nbr = nbrs.get(i);
                id[nbr] = id[nbr] - 1;
                if (id[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (isAns) {
            return ans;
        }

        return new int[]{}; // return empty array
    }
}
