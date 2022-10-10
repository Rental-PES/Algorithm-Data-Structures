package RawLinkedList;


import java.util.NoSuchElementException;

public class LinkedListTail {
    private class Node {
        private  int value;
        private  Node next;

        Node(int value){
            this.value = value;
        }

    }

    private  Node head;
    private  Node tail;
    private  int size = 0;


    //addTail
    public  void addTail(int item){
        var node = new Node(item);
        if (isEmpty())
            head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }
    //addHead
    public void addHead(int item){
        var node =  new Node(item);
        if (head == null) head = tail = node;
        else{
            node.next = head;
            head = node;
        }
        size++;
    }

    //deleteHead
    public void removeHead(){
        if (isEmpty()) throw  new NoSuchElementException();
        if (head == tail){
            head = tail = null;
        } else {
            var second = head.next;
            head.next = null;
            head = second;
        }
        size--;
    }
    //deleteTail
    public  void  removeTail(){
        if (isEmpty()) throw  new NoSuchElementException();
        if (head == tail){
            head = tail = null;
        } else{
            var previous = getPrevious(tail);
            tail = previous;
            tail.next = null;
        }
        size--;
    }

    private  Node getPrevious(Node node){
        var current = head;
        while (current != null){
            if (current.next == node) return  current;
            current = current.next;
        }
        return  null;
    }


    //contains
    public  boolean contains(int item){
        return  indexOf(item) != -1;
    }
    //indexOf
    public int indexOf(int item){
        int index = 0;
        var current = head;
        while (current != null){
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return  -1;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = head;

        var index = 0;
        while (current != null){
            array[index++] = current.value;
            current = current.next;
        }

        return  array;

    }

    public  void  reverse(){
        if (isEmpty()) return;
        // f            l
        // 10 -> 20 -> 30
        // l            f
        // 10 <- 20 <- 30
        // p     c      n
        // n = c.next
        // c.next = p 10 <-20
        var previous = head;
        var current = head.next;

        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        tail = head;
        tail.next = null;
        head = previous;

    }

    private  boolean isEmpty(){
        return  head == null;
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
