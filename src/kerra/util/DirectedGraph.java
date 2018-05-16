package kerra.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;

public class DirectedGraph<E> {

    private ArrayList<Node> graph;

    public DirectedGraph() {
        this(10);
    }

    public DirectedGraph(int initialSize) {
        this.graph = new ArrayList<>(initialSize);
    }

    public DirectedGraph(Node[] nodes) {
        this(nodes.length);
        Collections.addAll(graph, nodes);
    }



    public class Node {

        private E element;
        private Object[] conns;

        public Node(@NotNull E element) {
            this.element = element;
        }

        public void setConnections(@NotNull E[] targets, double[] weights) {
            this.conns = new Object[targets.length];
            for (int i = 0; i < targets.length; i++) conns[i] = new Connection(targets[i], weights[i]);
        }
    }

    private class Connection {
        private E target;
        private double weight;
        private Connection(@NotNull E target, double weight) {
            this.target = target;
            this.weight = weight;
        }
    }
}
