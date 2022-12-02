package MODUL5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public  class Graph{
    String name;
    int size = 0;
    Graph prev;
    Graph next;
    Vertex head;

    Graph(){

    }

    Graph(String name){
        this.name = name;
    }

    void bfs(Vertex start){
        Queue<Vertex> queue = new LinkedList<Vertex>();
        queue.add(start);
        for (int i = 0; i < size; i++){
            visitAllEdge(queue, start.listEdge);
        }
        while (!queue.isEmpty()){
            System.out.print(queue.peek().name + " : [");
            for (int i = 0; i<queue.peek().items.size(); i++){
                System.out.print(queue.peek().items.get(i));
                if (i < queue.peek().items.size()-1) System.out.print(",");
                if (i == queue.peek().items.size()-1) System.out.print("]\n");
            }
            queue.remove();
        }
    }



    void  visitAllEdge(Queue queue, EdgeContainer listEdge){
        if (listEdge == null){
            return;
        } else {
            Edge edgePivot = listEdge.head;
            for (int y = 0; y < listEdge.size; y++){
                if (!queue.contains(edgePivot.destination)){
                    queue.add(edgePivot.destination);
                    visitAllEdge(queue,edgePivot.destination.listEdge);
                }
                edgePivot = edgePivot.next;

            }
        }
    }
//
//    void bfs(Vertex start){
//        Queue<Vertex> queue = new LinkedList<Vertex>();
//        for (int i = 0; i < size; i++){
//            Vertex vertexPivot = start;
//            Edge edgePivot = vertexPivot.listEdge.head;
//            for (int y = 0; y < vertexPivot.listEdge.size; y++){
//                if (!queue.contains(edgePivot.destination)){
//                    System.out.println(edgePivot.destination.name);
//                    queue.add(edgePivot.destination);
//                }
//                if (edgePivot.next != null){
//                    edgePivot = edgePivot.next;
//                } else {
//                    vertexPivot = edgePivot.destination;
//                    break;
//                }
//            }
//        }
//    }
//    void bfs(Vertex start){
//        Vertex vertexPivot = start;
//        for (int i = 0; i < size; i++){
//            Edge edgePivot = vertexPivot.listEdge.head;
//            while (edgePivot != null){
//                System.out.println(edgePivot.destination.name);
//                if (edgePivot.next == null){
//                    break;
//                }
//                edgePivot = edgePivot.next;
//            }
//            if (edgePivot.next == null){
//                vertexPivot = edgePivot.destination;
//            }
//
//        }
//    }



//    void BFS(Vertex start){
//        LinkedList<String> visited = new LinkedList<String>();
//        LinkedList<Vertex> queue = new LinkedList<Vertex>();
//
//        Vertex pivot = start;
//
//
//        while (visited.size() != size){
//            Edge pivotEdge = pivot.listEdge.head;
//            while (pivotEdge.next == null) {
//                System.out.println("1");
//                if (!visited.contains(pivotEdge.destination.name)) {
//                    System.out.println("this");
//                    queue.add(pivotEdge.destination);
//                    visited.add(pivotEdge.destination.name);
//                }
//                pivot = pivotEdge.destination;
//                pivotEdge = pivotEdge.next;
//            }
//        }
//
//    }

    void insert(String name, String[] items){
        Vertex newVertex = new Vertex(name, items);
        if (isEmpty()){
            head = newVertex;
        } else {
            Vertex lastVertex = head;
            while (lastVertex.next != null){
                lastVertex = lastVertex.next;
            }
            lastVertex.insert(newVertex);
        }
        size+=1;
    }

    void insertEdge(String from, String to){
        Vertex fromGC = searchGraphContainer(from);
        Vertex toGC = searchGraphContainer(to);

        if (fromGC == null) {
            System.out.println("from tidak ditemukan");
        } else if(toGC == null){
            System.out.println("to tidak ditemukan");
        } else {
            fromGC.insertEdge(toGC);
        }

    }

    Vertex searchGraphContainer(String target){
        Vertex temp = head;
        while (temp != null){
            if (temp.name == target){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public boolean isEmpty(){
        return  head == null;
    }

    void printAll(){
        Vertex pivot = head;
        while (pivot != null){
            System.out.println("\n-------------------");
            System.out.println("Graph Container " + pivot.name + "\nEdge : ");
            pivot.listEdge.printAll();
            pivot = pivot.next;
            System.out.println("-------------------");
        }
    }

}