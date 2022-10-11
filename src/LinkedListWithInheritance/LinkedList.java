package LinkedListWithInheritance;

import java.util.NoSuchElementException;

public class LinkedList {
Node head;

    private class Node{
        Node next;
        Object value;
        Node(Object value){
            this.value = value;
        }
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void insertNode(Object value){
        var node =  new Node(value);
        if (head == null) head  = node;
        else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = node;
        }
    }

    public void deleteNode(){
        if (isEmpty()) throw  new NoSuchElementException();
        if (head.next == null){
            head  = null;
        } else{
            Node current = head;
            while (current.next.next != null){
                current = current.next;
            }
            current.next = null;
        }
    }

    void printAll(){
        Node node = head;
        while (true){
            if(node != null) {
                System.out.println(node.value);
                node = node.next;
            }
            else break;
        }
    }
}
