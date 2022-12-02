package MODUL5;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DLLGraph {
    int size = 0;
    Graph head;
    Graph tail;

    public void  insert(Graph graph){
        if (isEmpty()) head = tail= graph;
        else {
            graph.prev = tail;
            tail.next = graph;
            tail = graph;
        }
        size+=1;
    }

    void searchWithBfs(String target){
        Graph graphPivot = head;
        boolean found = false;
        List<String> listFound = new ArrayList<String>();
        for (int graphCount = 0; graphCount < size; graphCount++){
            Queue<Vertex> queue = new LinkedList<Vertex>();
            Vertex start = graphPivot.head;
            queue.add(start);
            for (int i = 0; i < head.size; i++){
                graphPivot.visitAllEdge(queue, start.listEdge);
            }
            while (!queue.isEmpty()){
                Vertex vertexPivot = queue.peek();
                for (int itemCount = 0; itemCount< vertexPivot.items.size(); itemCount++){
                    if (vertexPivot.items.get(itemCount) == target){
                        found = true;
                        listFound.add(graphPivot.name + " di " + vertexPivot.name);
                    }
                }
                queue.remove();
            }
            graphPivot = graphPivot.next;
        }

        if (found == true){
            System.out.println("Cari: " + target);
            System.out.println("Ketemu, " + target + " ada di");
            for (int i = 0; i<listFound.size(); i++){
                System.out.println(listFound.get(i));
            }
        }



    }

    private boolean isEmpty(){
        return (head == null);
    }

}
