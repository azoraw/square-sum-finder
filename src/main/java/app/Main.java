package app;

import app.hamilton.DFS;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    private static final int n = 50;

    public static void main(String[] args) {
        DFS dfs = new DFS();

        for(int i = 2; i<= n; i++) {
            Set<Node> graph = initGraph(i);
            System.out.println("path for n = " + i + " is:");
            System.out.println(dfs.findPath(graph));
        }

    }

    private static Set<Node> initGraph(int n) {
        SquareNumbers squareNumbers = new SquareNumbers(n);
        Set<Node> graph = new LinkedHashSet<>();

        graph.add(new Node(1, new HashSet<>(), false));

        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i, new HashSet<>(), false);

            graph.stream()
                    .filter(node -> squareNumbers.isSquare(newNode.getValue() + node.getValue()))
                    .forEach(node -> node.addNode(newNode));
            graph.add(newNode);
        }

        return graph;
    }
}
