package matrix;

import app.SquareNumbers;

public class Graph {

    boolean[][] graph;

    public void initGraph(int nodesNumber) {
        SquareNumbers squareNumbers = new SquareNumbers(nodesNumber);

        graph = new boolean[nodesNumber][nodesNumber];

        for (int i = 1; i <= nodesNumber; i++) {
            for (int j = 1; j <= nodesNumber; j++) {
                if (squareNumbers.isSquare(i + j) && j != i) {
                    graph[i - 1][j - 1] = true;
                }
            }
        }
    }

    void printGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                System.out.print(graph[i][j] ? 1 : 0);
                System.out.print(" ");
            }

            System.out.println();
        }
    }
}
