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

    private  Node first;
    private  Node last;
    private  int size = 0;


    //addLast
    public  void addLast(int item){
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }
    //addFirst
    public void addFirst(int item){
        var node =  new Node(item);
        if (first == null) first = last = node;
        else{
            node.next = first;
            first = node;
        }
        size++;
    }

    //deleteFirst
    public void removeFirst(){
        if (isEmpty()) throw  new NoSuchElementException();
        if (first == last){
            first = last = null;
        } else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }
    //deleteLast
    public  void  removeLast(){
        if (isEmpty()) throw  new NoSuchElementException();
        if (first == last){
            first = last = null;
        } else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private  Node getPrevious(Node node){
        var current = first;
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
        var current = first;
        while (current != null){
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return  -1;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;

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
        var previous = first;
        var current = first.next;

        while (current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;

    }

    private  boolean isEmpty(){
        return  first == null;
    }

    void printAll(LinkedListTail list){
        Node node = list.first;
        while (true){
            if(node != null) {
                System.out.println(node.value);
                node = node.next;
            }
            else break;
        }
    }
}
