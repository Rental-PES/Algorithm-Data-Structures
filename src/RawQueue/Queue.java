package RawQueue;



import java.util.NoSuchElementException;

public class Queue {
    Node front;
    Node back;

    private class Node{
        Node next;
        Object value;

        Node(Object value){
            this.value = value;
        }
    }

    public void enqueue(Object value){
        Node newNode = new Node(value);
        if (isEmpty()) front = back = newNode;
        else {
            newNode.next = back;
            back = newNode;
        }
    }

    public Object dequeue(){
        if (isEmpty()) throw new NoSuchElementException();
        else {
            Node returnItem = front;
            if (back.next == null) {
                back = front = null;
            } else {
                Node prev = getPrevious(front);
                prev.next = null;
                front = prev;
            }
            return returnItem.value;
        }
    }

    private Node getPrevious(Node node){
        var current = back;
        while (current != null){
            if (current.next == node) return  current;
            current = current.next;
        }
        return  null;
    }

    public  void printAll(){
        Node node = back;
        while (true){
            if(node != null) {
                System.out.print(node.value);
                if (node.next != null){
                    System.out.print("->");
                }
                node = node.next;
            }

            else break;
        }
        System.out.println("");
    }



    public boolean isEmpty(){
        return (front == null && back == null);
    }
}
