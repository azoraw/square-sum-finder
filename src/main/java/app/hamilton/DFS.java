package app.hamilton;

import app.Node;

import java.util.Set;
import java.util.Stack;

public class DFS {

    private Stack<Node> stack;
    private int n;
    boolean found;

    public String findPath(Set<Node> nodes) {
        if (canNotHavePath(nodes)) {
            return "impossible";
        }

        n = nodes.size();
        stack = new Stack<>();
        found = false;

        for (Node node : nodes) {
            dfs(node);
            if (found) {
               break;
            }
        }


        return found ? "" : "not found";
    }

    private void dfs(Node startNode) {
        stack.push(startNode);
        if (stack.size() < n) {
            startNode.setVisited(true);
            for (Node node : startNode.getEdges()) {
                if (!node.isVisited()) {
                    dfs(node);
                }
            }
            startNode.setVisited(false);
        } else {
            found = true;
            System.out.println(stack.toString());
        }
        stack.pop();
    }

    private boolean canNotHavePath(Set<Node> nodes) {
        return nodes.stream()
                .filter(node -> node.getEdges().size() < 2)
                .count() > 2;

    }

}
