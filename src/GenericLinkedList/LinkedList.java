package GenericLinkedList;

public class LinkedList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node() {}
        Node(T data) {
            this.data = data;
        }
    }

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

    public void addFront(T data) {
        if (head == null) {
            head = new Node<>(data);
            return;
        }

        Node<T> temp = new Node<>(data);
        temp.next = head;
        head = temp;
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

    public void add(T data) {
        addBack(data);
    }

    public void add(int index, T data) {
        Node<T> current = head;
        Node<T> temp;
        int pos = 0;
        if (index == 0) {
            addFront(data);
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
        } else {
            System.out.println("\nINDEX DOESN'T EXIST!!! CAN'T ADD NEW DATA!");
        }
    }

    public T begin() {
        return head.data;
    }

    public T end() {
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
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
        System.out.println("\nINDEX DOESN'T EXIST!!! CAN'T GET THE DATA!");
        return null;
    }

    public void popBack() {
        Node<T> current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
    }

    public void popFront() {
        head = head.next;
    }

    public void delete(int index) {
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
        System.out.println("\nINDEX DOESN'T EXIST!!! CAN'T DELETE THE DATA!");
    }

    public void clear() {
        Node<T> current = head;
        Node<T> temp;
        while (current != null) {
            temp = current;
            current = current.next;
            temp.next = null;
        }
        head = null;
    }

    public int size() {
        Node<T> current = head;
        int size = 0;
        while (current != null) {
            if (current.data != null)
                size++;
            current = current.next;
        }
        return size;
    }

    public int capacity() {
        Node<T> current = head;
        int capacity = 0;
        while (current != null) {
            capacity++;
            current = current.next;
        }
        return capacity;
    }

    public void resize(int size) {
        Node<T> current = head;
        int cap = capacity();
        while (current.next != null) {
            current = current.next;
        }
        while (cap < size) {
            current.next = new Node<>();
            current = current.next;
            cap++;
        }
    }

    public void swap(int index1, int index2) {
        if (index1 == index2)
            return;

        Node<T> prevX = getObj(index1 - 1), currX = getObj(index1);

        Node<T> prevY = getObj(index2 - 1), currY = getObj(index2);

        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        Node<T> temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public Node<T> getObj(int index) {
        Node<T> current = head;
        int pos = 0;
        while (current != null) {
            if (index == pos) {
                return current;
            } else
                pos++;
            current = current.next;
        }
        System.out.println("\nINDEX DOESN'T EXIST!!! CAN'T GET THE DATA!");
        return null;
    }

}