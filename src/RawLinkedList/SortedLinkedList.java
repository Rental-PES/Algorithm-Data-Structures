package RawLinkedList;

public class SortedLinkedList {
    Node head;
    private class Node{
        Node next;
        int value;
        Node(int value){
            this.value = value;
        }
    }

    public void insert(int value){
        Node newNode = new Node(value);
        if(head == null) head = newNode;
        else {
            enum  Status{
                SAME,
                GREATER,
                LOWER,
            }
            Status status = Status.GREATER;

            Node current = head;
            Node mark = null;

            //cek status nilai apakah sama, lebih besar, atau lebih kecil
            while (current != null){
                if (current.value == newNode.value){
                    mark = current;
                    status = Status.SAME;
                    break;
                } else if(newNode.value < current.value){
                    mark = current;
                    status = Status.LOWER;
                    break;
                } else {
                    //status tetap greater
                    mark = current;
                }
                current = current.next;
            }
            //aksi berdasarkan status
            // status same dan greater digabung karena sama sama ditaruh di kanan
            if (status == Status.SAME || status == Status.GREATER){
                if (mark.next != null) {
                    //kalau mark next nya ada item, dipindah dulu ke newnode, baru lanjut ke line berikutnya
                    newNode.next = mark.next;
                }
                // kalau mark.next == null, langsung assign
                mark.next = newNode;
            } else {
                // status lower
                Node prevMark = getPrevious(mark);
                newNode.next = mark;
                if (prevMark == null){
                    head = newNode;
                } else {
                    prevMark.next = newNode;
                }
            }
        }
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


    public int length(){
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
