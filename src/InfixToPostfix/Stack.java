package InfixToPostfix;

import java.util.NoSuchElementException;

public class Stack {
    private  Node top;
    private  Node bottom;

      int size = 0;

    public Node getTop(){
        return top;
    }

    public char peek(){
        return top.value;
    }

    public void push(char value){
        var node = new Node(value);
        if (top == null) top = bottom = node;
        else{
            node.next = top;
            top = node;
        }
        size++;
    }

    public char pop(){
        if (isEmpty()) throw new NoSuchElementException();
        var popItem = top;
        if (top == bottom) top = bottom = null;
        else {
            var second = top.next;
            top.next = null;
            top = second;
        }
        size--;
        return popItem.value;
    }

    public  void printAll(){
        Node node = top;
        while (true){
            if(node != null) {
                System.out.println(node.value);
                node = node.next;
            }
            else break;
        }
    }
    public   boolean isEmpty(){
        return  top == null;
    }

}
