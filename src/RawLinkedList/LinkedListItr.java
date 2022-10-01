package RawLinkedList;


public class LinkedListItr {
    Node head;
    Node current = head;

    private class Node{
        Node next;
        Object value;
        Node(Object value){
            this.value = value;
        }
    }

    public void first(){
        current = head;
    }

    public void insertNext(Object x){
        if (head == null){
            head = current = new Node(x);
        }
        else {
            if (current.next == null){
                current.next = new Node(x);
            } else {
                Node nextNode = current.next;
                Node newNode = new Node(x);

                newNode.next = nextNode;
                current.next = newNode;
            }
            current = current.next;
        }
    }

    public void deleteNext(){
        if (head == null || current.next == null) System.out.println("tidak ada element, tidak dapat menghapus");
        else {
            if (current.next.next == null){
                current.next = null;
            } else {
                // 1 ->3 | 2->3
                Node target = current.next.next; //3
                current.next.next = null; // 1 -> 3 | 2 3
                current.next = target;
            }
        }


    }

    public Object  retrieve(){
        return current.value;
    }

    public void locate(Object x){
        Node temp = head;
        while (temp != null){
            if (temp.value == x){
                current = temp;
                System.out.println("Berhasil mendapatkan dan merubah current dengan objek");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Tidak Ditemukan. Gagal mendapatkan dan merubah current dengan objek");
        return;
    }

    public boolean isLast(){
        return current.next == null;
    }

    public boolean isPastEnd(){
        return current == null;
    }


    public  void advance(){
        if(!isPastEnd()) current = current.next;
    }


    public boolean isInList(){
        return current != null;
    }

    public void printAll(){
        Node current = head;
        while (current != null){
            System.out.println("printed : " + current.value);
            current = current.next;
        }
    }

}
