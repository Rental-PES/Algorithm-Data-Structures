package MODUL5;


public class DLLGraph {
    Graph head;
    Graph tail;

    public void  insert(Graph graph){
        if (isEmpty()) head = tail= graph;
        else {
            graph.prev = tail;
            tail.next = graph;
            tail = graph;
        }
    }

    private boolean isEmpty(){
        return (head == null);
    }

}
