package app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Node {

    private final Integer value;
    private Set<Node> edges;

    boolean addNode(Node newNode) {
        newNode.getEdges().add(this);
        return edges.add(newNode);
    }

}
