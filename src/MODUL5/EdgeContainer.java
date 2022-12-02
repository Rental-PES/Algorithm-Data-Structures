package MODUL5;

public class EdgeContainer {
    Edge head;
    Edge tail;
    int size = 0;

    public void  addLast(Vertex destination){
        Edge newEdge = new Edge(destination);
        if (isEmpty()) head = tail = newEdge;
        else {
            Edge last = getLast();
            newEdge.prev = last;
            last.next = newEdge;
            tail = newEdge;
        }
        size+= 1;
    }

    private boolean isEmpty(){
        return (head == null);
    }

    private Edge getLast(){
        Edge current = head;
        while (current.next != null){
            current = current.next;
        }
        return current;
    }

    void printAll(){
        Edge Edge = head;
        while (true){
            if(Edge != null) {
                System.out.println(Edge.destination.name);
                Edge = Edge.next;
            }
            else break;
        }
    }

//    void printReverse(){
//        Edge Edge = tail;
//        while (true){
//            if(Edge != null) {
//                System.out.println(Edge.destination);
//                Edge = Edge.prev;
//            }
//            else break;
//        }
//    }
}
