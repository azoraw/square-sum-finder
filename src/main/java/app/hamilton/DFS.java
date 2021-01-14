package app.hamilton;

import java.util.Comparator;
import java.util.Set;
import java.util.Stack;

public class DFS {

    public Stack<Node> stack;
    private int n;
    private boolean found;

    public String findPath(Set<Node> nodes) {
        n = nodes.size();
        stack = new Stack<>();
        found = false;

        Node initNode = nodes.stream()
                .max(Comparator.comparing(node -> node.getEdges().size()))
                .orElseThrow(RuntimeException::new);

        dfs(initNode);

        return found ? "and is beautiful\n" : "not found";
    }

    private void dfs(Node node) {
        stack.push(node);
        if (stack.size() < n || found) {
            node.setVisited(true);
            for (Node neighbour : node.getEdges()) {
                if (!neighbour.isVisited()) {
                    dfs(neighbour);
                }
            }
            node.setVisited(false);
        } else {
            found = true;
            System.out.println("result: " + stack.toString() +"\n\n");
        }
        stack.pop();
    }
}
