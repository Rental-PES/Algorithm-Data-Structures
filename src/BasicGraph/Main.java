package BasicGraph;

public class Main {
    public static void main(String[] args) {
        // Graph ( contain list of graph container )
        // Vertex ( contain listEdge, and name )
        // ListEdge ( contain list of edge, using doubly linked list concept )
        // Edge ( contain destination to another vertex
        Graph graph = new Graph();
        graph.insert("SLP");
        graph.insert("AMP");
        graph.insert("KBR");
        graph.insert("AAA");


        graph.insertEdge("SLP", "AMP");
        graph.insertEdge("SLP", "KBR");
        graph.insertEdge("SLP", "AAA");

        graph.insertEdge("KBR", "AMP");
        graph.insertEdge("KBR", "AAA");

        graph.printAll();
    }
}