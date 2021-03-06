import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private class Node {
        public Node(String label) {
            this.label = label;
        }

        public String label;

        @Override
        public String toString() {
            return  label;
        }
    }

    private Map<String, Node> nodes = new HashMap<>();
    private Map<Node, List<Node>> adjacencyList = new HashMap<>();

    public void  addNode(String label) {
        var node = new Node(label);

        nodes.putIfAbsent(label, node);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        var fromNode = nodes.get(from);
        if(fromNode == null) {
            throw new IllegalArgumentException();
        }

        var toNode = nodes.get(to);
        if(toNode == null) {
            throw new IllegalArgumentException();
        }

        adjacencyList.get(fromNode).add(toNode);
    }

    public void removeNode(String label) {
        var node = nodes.get(label);
        if(node == null) {
            return;
        }

        for (var n : adjacencyList.keySet()){
            adjacencyList.get(n).remove(node);
        }

        adjacencyList.remove(node);
        nodes.remove(node);
    }

    public void removeEdge(String from, String to) {
        var fromNode = nodes.get(from);
        var toNode = nodes.get(to);

        if (from == null || toNode == null) {
            return;
        }

        adjacencyList.get(fromNode).remove(toNode);

    }

    public void print() {
        for (var source: adjacencyList.keySet()){
            var targets = adjacencyList.get(source);
            if(!targets.isEmpty())
                System.out.println(source + "is connected" + targets);
        }
    }
}
