package app;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Node {

    private final Integer value;
    private Set<Node> edges;
    private boolean visited = false;

    boolean addNode(Node newNode) {
        newNode.getEdges().add(this);
        return edges.add(newNode);
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
