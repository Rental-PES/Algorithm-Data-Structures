package RawLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    Node head;
    Node tail;
    private class Node{
        Node next;
        Node prev;
        Object value;
        Node(Object value){
            this.value = value;
        }
    }

    public void  addLast(Object value){
        Node newNode = new Node(value);
        if (isEmpty()) head = tail= newNode;
        else {
            Node last = getLast();
            // last <- newnode
            newNode.prev = last;
            // last -> newnode
            last.next = newNode;
            tail = newNode;
        }
    }

    public void addFirst(Object value){
        Node newNode = new Node(value);
        if (isEmpty()) head = tail = newNode;
        else {
            // newnode -> x (head)
            newNode.next = head;
            // newnode (head) -> x
            head = newNode;
            // newnode <- x
            head.next.prev = head;
            // if x.next == null || tail
            if (head.next.next == null) tail = head.next;
        }
    }

    public void deleteFirst(){
        if (isEmpty()) return;
        else if (head.next == null)  head = tail = null;
        else {
            Node newHead = head.next;
            // a -> b = a b
            head.next = null;
            // b (head)
            head = newHead;
            // a <- b = a b
            head.prev = null;
            if (head.next == null) tail = head;
        }
    }

    public  void  deleteLast(){
        if (isEmpty()) return;
        else if (head.next == null)  head = null;
        else {
            Node current = head;
            while (current.next.next != null){
                current = current.next;
            }
            // current = object before last

            // a <- b = a b
            current.next.prev = null;
            // a -> b = a b
            current.next = null;
            tail = current;
        }
    }

    public  void deleteAfter(Object value){
        Node current = head;
        boolean isFound = false;
        while (current.next != null){
            if (current.value == value) {
                isFound = true;
                break;
            };
            current = current.next;
        }
        if (isFound){
            if (current.next.next != null) {
                // current -> target
                // current <- target

                // current target
                // current -> new
                current.next = current.next.next;
                current.next.prev = current;

                // gak implement clear unused node null
            } else {
                deleteLast();
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public void insertAfter(Object after, Object value){
        Node newNode = new Node(value);
        Node current = head;
        boolean isFound = false;
        while (true){
            if (current.value == after) {
                isFound = true;
                break;
            };
            if (current.next == null) break;
            current = current.next;
        }
        if (isFound){
            if (current.next == null){
                addLast(value);
            } else {
                // current -> <- nextToCurrent
                Node nextToCurrent = current.next;
                // current -> newnode
                current.next = newNode;
                // current <- newnode;
                newNode.prev = current;
                //newNode -> nexToCurrent
                newNode.next = nextToCurrent;
                // newNode <- nextTocurrent
                nextToCurrent.prev = newNode;
            }
        } else {
            throw new NoSuchElementException();
        }
    }


    public void deleteBefore(Object value){
        Node current = head;
        boolean isFound = false;
        while (current.next != null){
            if (current.value == value) {
                isFound = true;
                break;
            };
            current = current.next;
        }
        if (isFound){
            if (current.prev.prev != null) {
                // target <- current
                // target current
                current.prev = current.prev.prev;
                // target -> current
                // new -> current
                current.prev.next = current;
                // gak implement clear unused node null
            } else {
                deleteFirst();
            }
        } else {
            throw new NoSuchElementException();
        }
    }

    public void insertBefore(Object before, Object value) {
        Node newNode = new Node(value);
        Node current = head;
        boolean isFound = false;
        while (true) {
            if (current.value == before) {
                isFound = true;
                break;
            }
            ;
            if (current.next == null) break;
            current = current.next;
        }
        if (isFound) {
            if (current.prev == null) {
                addFirst(value);
            } else {
                // prevFromCurrent -> <- current
                Node prevFromCurrent = current.prev;
                // prevFromCurrent -> newNode
                prevFromCurrent.next = newNode;
                // prevFromCurrent <- newNode
                newNode.prev = prevFromCurrent;
                // newNode -> current
                newNode.next = current;
                // newNode <- current
                current.prev = newNode;
            }
        } else {
            throw new NoSuchElementException();
        }
    }



    private boolean isEmpty(){
        return (head == null);
    }

    private Node getLast(){
        Node current = head;
        while (current.next != null){
            current = current.next;
        }
        return current;
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

    void printReverse(){
        Node node = tail;
        while (true){
            if(node != null) {
                System.out.println(node.value);
                node = node.prev;
            }
            else break;
        }
    }
}
