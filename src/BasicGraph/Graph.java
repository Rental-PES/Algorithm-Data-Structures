package BasicGraph;

public  class Graph{
    Vertex head;

    void insert(String name){
        Vertex newVertex = new Vertex(name);
        if (isEmpty()){
            head = newVertex;
        } else {
            Vertex lastVertex = head;
            while (lastVertex.next != null){
                lastVertex = lastVertex.next;
            }
            lastVertex.insert(newVertex);
        }
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