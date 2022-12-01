package MODUL5;

public class Vertex {
    String name;
    Vertex next;
    EdgeContainer listEdge = new EdgeContainer();

    Vertex(String name){
        this.name = name;
    }

    public void insert(Vertex vertex){
       next = vertex;
    }

    public void insertEdge(Vertex targetVertex){
        listEdge.addLast(targetVertex);
    }





}