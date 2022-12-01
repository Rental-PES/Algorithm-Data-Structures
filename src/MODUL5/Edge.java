package MODUL5;

public class Edge{
    Edge next;
    Edge prev;
    Vertex destination;
    Edge(Vertex destination){
        this.destination = destination;
    }
}