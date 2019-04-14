package app;

import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
class Node {

    private Integer integer;
    private Set<Integer> links = new HashSet<>();

    boolean addLink(int i) {
        return links.add(i);
    }

}
