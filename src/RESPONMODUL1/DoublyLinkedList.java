package RESPONMODUL1;

import java.util.Objects;

public class DoublyLinkedList {
    Node head;
    Node tail;
    private class Node{
        Node next;
        Node prev;
        String value;
        Node(String value){
            this.value = value;
        }
    }

    public void  addLast(String value){
        Node newNode = new Node(value);
        if (isEmpty()) head = tail= newNode;
        else {
            Node last = getLast();
            newNode.prev = last;
            last.next = newNode;
            tail = newNode;
        }
    }


    Node deleteNode(Node pointer){
        if (head == null || pointer == null) return head;
        if (head == pointer) head = pointer.next;
        if (pointer.next != null) pointer.next.prev = pointer.prev;
        if (pointer.prev != null) pointer.prev.next = pointer.next;
        return head;
    }


    public Node removeDuplicate(Node listHead){
        Node pointer1, pointer2;
        for (pointer1 = listHead; pointer1 != null; pointer1 = pointer1.next){
            pointer2 = pointer1.next;
            while (pointer2 != null){
                if (Objects.equals(pointer1.value, pointer2.value)){
                    Node next = pointer2.next;
                    listHead = deleteNode(pointer2);
                    pointer2 = next;
                }
                else pointer2 = pointer2.next;
            }
        }
        return listHead;
    }


    public void joinWithoutDuplicate(DoublyLinkedList anotherList){
        // delete duplicate current
        anotherList.head.prev = tail;
        tail.next = anotherList.head;
        tail = anotherList.tail;
        removeDuplicate(head);
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
                System.out.print(node.value);
                if (node.next != null) System.out.print("->");
                node = node.next;
            }
            else break;
        }
        System.out.println();
    }

    void printReverse(){
        Node node = tail;
        while (true){
            if(node != null) {
                System.out.print(node.value);
                if (node.prev != null) System.out.print("<-");
                node = node.prev;
            }
            else break;
        }
        System.out.println();
    }
}
