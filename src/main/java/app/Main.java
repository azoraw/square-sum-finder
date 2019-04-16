package app;

import app.hamilton.BruteForce;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final int n = 6;

    public static void main(String[] args) {
        Set<Node> graph = initGraph();

        BruteForce bruteForce = new BruteForce();
        String path = bruteForce.findPath(graph);
        System.out.println("path for n = " + n + " is " + path);

    }

    private static Set<Node> initGraph() {
        SquareNumbers squareNumbers = new SquareNumbers(n);
        Set<Node> graph = new HashSet<>();

        graph.add(new Node(1, new HashSet<>()));

        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i, new HashSet<>());

            graph.stream()
                    .filter(node -> squareNumbers.isSquare(newNode.getValue() + node.getValue()))
                    .forEach(node -> node.addNode(newNode));
            graph.add(newNode);
        }

        return graph;
    }
}
