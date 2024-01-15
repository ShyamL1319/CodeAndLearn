import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 16/01/2024:01:05
 * User: shyamlal
 * Problem Description
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * <p>
 * Note: The test cases are generated in the following format (use the following format to use See Expected Output option):
 * First integer N is the number of nodes.
 * Then, N intgers follow denoting the label (or hash) of the N nodes.
 * Then, N2 integers following denoting the adjacency matrix of a graph, where Adj[i][j] = 1 denotes presence of an undirected edge between the ith and jth node, O otherwise.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= Number of nodes <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a node A denoting the root of the undirected graph.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the node denoting the root of the new clone graph.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * 1
 * / | \
 * 3  2  4
 * / \
 * 5   6
 * Input 2:
 * <p>
 * 1
 * / \
 * 3   4
 * /   /|\
 * 2   5 7 6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * Output will the same graph but with new pointers:
 * 1
 * / | \
 * 3  2  4
 * / \
 * 5   6
 * Output 2:
 * <p>
 * 1
 * / \
 * 3   4
 * /   /|\
 * 2   5 7 6
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * We need to return the same graph, but the pointers to the node should be different.
 */
class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}

public class CloneGraph {
    Map<Integer, UndirectedGraphNode> visited = new HashMap<>();

    public static void main(String[] args) {

    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return node;
        UndirectedGraphNode new_graph = new UndirectedGraphNode(node.label);
        visited.put(node.label, new_graph);
        List<UndirectedGraphNode> list = node.neighbors;
        for (int i = 0; i < node.neighbors.size(); i++) {

            if (!visited.containsKey(list.get(i).label)) {
                UndirectedGraphNode cloned_node = cloneGraph(list.get(i));
                new_graph.neighbors.add(cloned_node);
            } else {
                new_graph.neighbors.add(visited.get(list.get(i).label));
            }
        }
        return new_graph;
    }
}
