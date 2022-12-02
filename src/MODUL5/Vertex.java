package MODUL5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vertex {
    String name;
    Vertex next;
    List<String> items = new ArrayList<String>();
    EdgeContainer listEdge = new EdgeContainer();

    Vertex(String name, String[] items){
        this.name = name;
        this.items.addAll(Arrays.asList(items));
    }

    public void insert(Vertex vertex){
       next = vertex;
    }

    public void insertEdge(Vertex targetVertex){
        listEdge.addLast(targetVertex);
    }





}