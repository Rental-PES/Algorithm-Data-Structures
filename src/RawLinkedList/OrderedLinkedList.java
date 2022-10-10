package RawLinkedList;

public class OrderedLinkedList {
    Node head;
    private class Node {
        Node(Object value){
            this.value = value;
        }
        Object value;
        Node next;
    }

    int length(){
        Node current = head;
        int length = 0;
        while(current.next !=null){
            length+=1;
            current = current.next;
        }
        return length;
    }

    public Object retrieve(int index){
        Node current = head;
        int i = 0;
        while (current.next != null){
            if (index == i) return  current.value;
            i+=1;
            current = current.next;
        }
        return null;
    }

    public void insert(int index, Object value){
        if (head == null){
            head = new Node(value);
            return;
        }
        Node newNode = new Node(value);
        Node current = head;
        Node target;
        int i = 0;
        while (true){
            if (i == index){ // index ada yang isi
                target = current;
                Node previous = getPrevious(target);
                previous.next = newNode;
                newNode.next = target;
                return;
            }
            // awalnya make while (current.next == null) tapi kondisi i==index ga dijalanin
            // karena whilenya duluan berhenti sebelum pengecekan, karena i nya berubah di akhir loop.
            if (current.next == null) break;
            i+=1;
            current = current.next;
        }
        // ketika index nya gaada yang isi
        current.next = newNode;
        return;
    }

    public void  delete(int index){
        if (index > length()){
            System.out.println("Node tidak ditemukan");
            return;
        }
        Node current = head;
        Node target;
        // case : mau delete awal
        if (index == 0) {
            if (head.next == null) head = null;
            else {
                target = head.next;
                head.next = null;
                head = target;
            }
            System.out.println("berhasil di hapus");
            return;
        }
        int i = 0;
        while (current != null) {
            if (index == i){
                target = current;
                Node previous = getPrevious(target);
                previous.next = target.next;
                target.next = null;
                System.out.println("berhasil di hapus");
                return;
            }
            i+=1;
            current = current.next;
        }
    }

    private Node getPrevious(Node node){
        var current = head;
        while (current != null){
            if (current.next == node) return  current;
            current = current.next;
        }
        return  null;
    }




    void printAll(OrderedLinkedList list){
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
