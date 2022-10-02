package GenericLinkedList;

public class LinkedList<T> {
    Node<T> head;

    public void addBack(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(data);
    }

    public void printAll() {
        Node<T> current = head;
        if (head == null) {
            System.out.println("HEAD DOESN'T EXIST!!!");
            return;
        }
        System.out.print("[");
        while (current != null) {
            if (!(current.next == null))
                System.out.print(current.data + ", ");
            else
                System.out.print(current.data);
            current = current.next;
        }
        System.out.println("]");
    }

    public void insert(int index, T data) {
        Node<T> current = head;
        Node<T> temp;
        int pos = 0;
        if (index == 0) {
            temp = head;
            head = new Node<>(data);
            head.next = temp;
            return;
        }
        while (current.next != null) {
            if (index - 1 == pos) {
                temp = current.next;
                current.next = new Node<>(data);
                current.next.next = temp;
                return;
            } else
                pos++;
            current = current.next;
        }
        if (index - 1 == pos) {
            current.next = new Node<>(data);
            return;
        } else {
            System.out.println("\nINDEX DOESNT EXIST!!! CAN'T ADD NEW DATA!");
        }
    }

    public T get(int index) {
        Node<T> current = head;
        int pos = 0;
        while (current != null) {
            if (index == pos) {
                return current.data;
            } else
                pos++;
            current = current.next;
        }
        System.out.println("\nINDEX DOESNT EXIST!!! CAN'T GET THE DATA!");
        return null;
    }

    public void delete (int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        int pos = 0;
        while (current.next != null) {
            if (index - 1 == pos) {
                current.next = current.next.next;
                return;
            } else
                pos++;
            current = current.next;
        }
        System.out.println("\nINDEX DOESNT EXIST!!! CAN'T DELETE THE DATA!");
    }

}

class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
    }
}

