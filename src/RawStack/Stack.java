package RawStack;
import java.util.NoSuchElementException;

public class Stack {
    private  Node first;
    private  Node last;

    private  int size = 0;
    private  class Node{
        private Object value;
        private Node next;

        Node(Object value){
            this.value = value;
        }
    }

    public void push(Object value){
        var node = new Node(value);
        if (first == null) first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    public Object pop(){
        if (isEmpty()) throw new NoSuchElementException();
        var popItem = first;
        if (first == last) first = last = null;
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        return popItem.value;
    }

    public  void printAll(Stack stack){
        Node node = stack.first;
        while (true){
            if(node != null) {
                System.out.println(node.value);
                node = node.next;
            }
            else break;
        }
    }
    private  boolean isEmpty(){
        return  first == null;
    }

}
