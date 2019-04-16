package app;

import app.hamilton.DFS;

import java.util.HashSet;
import java.util.Set;

public class Main {

    private static final int n = 300;

    public static void main(String[] args) {
        DFS dfs = new DFS();

        for (int i = 2; i <= n; i++) {
            Set<Node> graph = initGraph(i);
            System.out.println();
            System.out.println("path for n = " + i + " is:");
            long startTime = System.currentTimeMillis();
            String path = dfs.findPath(graph);
            System.out.println(path);
            long endTime = System.currentTimeMillis();
            System.out.println("finding path " + i +" took :  " + (endTime - startTime) + " milliseconds");
        }
    }

    private static Set<Node> initGraph(int n) {
        SquareNumbers squareNumbers = new SquareNumbers(n);
        Set<Node> graph = new HashSet<>();

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
