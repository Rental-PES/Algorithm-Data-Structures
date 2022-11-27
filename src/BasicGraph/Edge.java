package BasicGraph;

public class Edge{
    Edge next;
    Edge prev;
    Vertex destination;
    Edge(Vertex destination){
        this.destination = destination;
    }
}